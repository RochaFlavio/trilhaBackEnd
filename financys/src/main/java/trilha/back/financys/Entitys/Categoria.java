package trilha.back.financys.Entitys;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;

@Table(name = "categorias")
@Entity(name = "Categoria")
@EqualsAndHashCode(of = "id")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome não pode ser Nulo ou Vazio")
    @Size(min = 3, max = 15, message = "O nome deve ter entre 3 e 15 caracteres." )
    private String nome;

    @NotBlank(message = "descrição não pode ser Nulo ou Vazio")
    @Size(min = 15, max = 50, message = "A descriçãp deve ter entre 15 e 50 caracteres.")
    private String descricao;

    public void atualizarCategoria(@Valid Categoria dados) {
        if (dados.getNome() != null) {
            this.nome = dados.getNome();
        }
        if (dados.getDescricao() != null) {
            this.descricao = dados.getDescricao();
        }
    }

    public Categoria() {
    }


    public Categoria(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
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
}