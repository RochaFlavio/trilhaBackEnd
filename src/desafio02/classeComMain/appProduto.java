package desafio02.classeComMain;

import desafio02.Produto;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class appProduto {
    public static void main(String[] args) {
        List<Produto> todos = new ArrayList<>();
        
        todos.add(new Produto(1, "Mario Card", "Jogo de aventura", 250.00));
        todos.add(new Produto(2, "FC25", "Jogo de fut", 200.00));
        todos.add(new Produto(3, "PS5", "Video game", 5000.00));
        todos.add(new Produto(4, "XBOX", "Video game", 4500.00));
        todos.add(new Produto(5, "Diablo", "Jogo de aventura", 329.00));

        for (Produto p : todos) {
            p.setPreco(p.getPreco() + 10.0);
        }

        List<Produto> maisCaros = new ArrayList<>(todos);
        maisCaros.sort(Comparator.comparingDouble(Produto::getPreco).reversed());

        if (maisCaros.size() > 3) {
            maisCaros = new ArrayList<>(maisCaros.subList(0, 3));
        }

        System.out.println("Produtos mais caros:");
        maisCaros.forEach(System.out::println);

        System.out.println("\nTodos os produtos:");
        todos.forEach(System.out::println);
    }
}