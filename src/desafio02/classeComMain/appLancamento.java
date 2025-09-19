package desafio02.classeComMain;

import desafio02.Lancamento;

public class appLancamento {
    public static void main(String[] args) {
        
        Lancamento l1 = new Lancamento(1, "FC25", "Jogo de fut", "Esporte",
                                       10, "18/09/2025", true, 2);
        
        Lancamento l2 = new Lancamento();
        l2.setId(2);
        l2.setNome("PS5");
        l2.setDescricao("Video game");
        l2.setTipo("Console");
        l2.setQuantidade(15);
        l2.setData("01/03/2023"); 
        l2.setPago(true);
        l2.setIdCategoria(1);
        
        System.out.println("LANÇAMENTOS:");
        System.out.println(l1.toString());
        System.out.println(l2.toString());
    }
}