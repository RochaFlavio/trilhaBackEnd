package trilha.back.financys.entitys;

    public class Categoria {


        private int id;
        private String nome;
        private String descricao;


        public Categoria() {}


        public Categoria(int id, String nome, String descricao) {
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

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getNome() { return nome; }
        public void setNome(String nome) { this.nome = nome; }

        public String getDescricao() { return descricao; }
        public void setDescricao(String descricao) { this.descricao = descricao; }
    }
