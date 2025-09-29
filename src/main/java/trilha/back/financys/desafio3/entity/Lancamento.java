package trilha.back.financys.desafio3.entity;

import java.time.LocalDate;
import java.util.Date;

public class Lancamento {

    private int id;
    private String nome;
    private String descricao;
    private String tipo;
    private int quantidade;
    private LocalDate data;
    private Boolean pago;
    private int idCategoria;


    public Lancamento() {}


    public Lancamento(int id, String nome, String descricao, String tipo,
                      int quantidade, LocalDate data, Boolean pago, int idCategoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.data = data;
        this.pago = pago;
        this.idCategoria = idCategoria;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Lancamento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", tipo='" + tipo + '\'' +
                ", quantidade=" + quantidade +
                ", data='" + data + '\'' +
                ", pago=" + pago +
                ", idCategoria=" + idCategoria +
                '}';
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public Boolean getPago() { return pago; }
    public void setPago(Boolean pago) { this.pago = pago; }

    public int getIdCategoria() { return idCategoria; }
    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }
}

