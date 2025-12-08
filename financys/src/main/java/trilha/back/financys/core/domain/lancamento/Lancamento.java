package trilha.back.financys.core.domain.lancamento;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import trilha.back.financys.core.domain.categoria.Categoria;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "lancamentos")
@Entity(name = "Lancamento")
@EqualsAndHashCode(of = "id")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome não pode ser nulo ou vazio")
    @Size(min = 3, max = 45, message = "O nome deve ter entre 3 e 45 caracteres")
    private String nome;

    @NotBlank(message = "Descrição não pode ser nula ou vazia")
    @Size(min = 15, max = 150, message = "A descrição deve ter entre 15 e 150 caracteres")
    private String descricao;

    @NotNull(message = "Tipo não pode ser nulo")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", length = 20)
    private TipoLancamento tipo;

    @NotNull(message = "Quantidade não pode ser nula")
    @PositiveOrZero(message = "A quantidade não pode ser negativa")
    private Integer quantidade;

    @NotNull(message = "Data não pode ser nula")
    private LocalDate data;


    @NotNull(message = "Campo 'pago' não pode ser nulo")
    private Boolean pago;


    @PositiveOrZero(message = "O valor não pode ser negativo")
    private BigDecimal valor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Categoria")
    @JsonIgnore
    private Categoria categoria;

    public Lancamento() {
    }

    public Lancamento(Long id, String nome, String descricao, TipoLancamento tipo,
                      Integer quantidade, LocalDate data, Boolean pago, Categoria categoria,  BigDecimal valor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.data = data;
        this.pago = pago;
        this.categoria = categoria;
        this.valor = valor;
    }

    public void atualizarLancamento(Lancamento dados) {
        if (dados == null) return;

        if (dados.getNome() != null) {
            this.nome = dados.getNome();
        }
        if (dados.getDescricao() != null) {
            this.descricao = dados.getDescricao();
        }
        if (dados.getTipo() != null) {
            this.tipo = dados.getTipo();
        }
        if (dados.getQuantidade() != null && dados.getQuantidade() != 0) {
            this.quantidade = dados.getQuantidade();
        }
        if (dados.getData() != null) {
            this.data = dados.getData();
        }
        if (dados.getPago() != null) {
            this.pago = dados.getPago();
        }
        if (dados.getCategoria() != null && dados.getCategoria().getId() != null) {
            this.categoria = dados.getCategoria();
        }
        if (dados.getValor() != null) {
            this.valor = dados.getValor();
        }
    }

    @JsonProperty("id_Categoria")
    public Long getIdCategoria() {
        return (categoria != null) ? categoria.getId() : null;
    }

    @JsonProperty("id_Categoria")
    public void setIdCategoriaJson(Long idCategoria) {
        if (idCategoria != null) {
            Categoria c = new Categoria();
            c.setId(idCategoria);
            this.categoria = c;
        }
    }


    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoLancamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoLancamento tipo) {
        this.tipo = tipo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Lancamento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", tipo='" + tipo + '\'' +
                ", quantidade=" + quantidade +
                ", data=" + data +
                ", pago=" + pago +
                ", idCategoria=" + (categoria != null ? categoria.getId() : null) +
                "valor=" + valor +
                '}';
    }
}