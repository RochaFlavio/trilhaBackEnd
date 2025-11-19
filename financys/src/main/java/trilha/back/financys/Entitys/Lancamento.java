package trilha.back.financys.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import trilha.back.financys.DTOs.DtoAtualizarLancamento;

import java.time.LocalDate;

@Table(name = "lancamentos")
@Entity(name = "Lancamento")
@EqualsAndHashCode(of = "id")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String tipo;
    private Integer quantidade;
    private LocalDate data;
    private Boolean pago;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Categoria")
    @JsonIgnore
    private Categoria categoria;

    public Lancamento() {
    }

    public Lancamento(Long id, String nome, String descricao, String tipo,
                      Integer quantidade, LocalDate data, Boolean pago, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.data = data;
        this.pago = pago;
        this.categoria = categoria;
    }

    public void atualizarLancamento(DtoAtualizarLancamento dados) {
        if (dados.nome() != null)
            this.nome = dados.nome();
        if (dados.descricao() != null)
            this.descricao = dados.descricao();
        if (dados.tipo() != null)
            this.tipo = dados.tipo();
        if (dados.quantidade() != null && dados.quantidade() != 0)
            this.quantidade = dados.quantidade();
        if (dados.data() != null)
            this.data = LocalDate.parse(dados.data());
        if (dados.pago() != null)
            this.pago = dados.pago();
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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

    @JsonProperty("id_Categoria")
    public Long getIdCategoriaJson() {
        return (categoria != null) ? categoria.getId() : null;
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
                '}';
    }
}
