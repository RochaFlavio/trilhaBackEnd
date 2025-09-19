package desafio02.classeComMain;

import desafio02.Categoria;

public class appCategoria {
    public static void main(String[] args) {
        
        Categoria c1 = new Categoria(1, "Gamer", "Consoles");

      
        Categoria c2 = new Categoria();
        c2.setId(2);
        c2.setNome("Gamer");
        c2.setDescricao("Jogo");

        
        System.out.println("CATEGORIAS:");
        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }
}