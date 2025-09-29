package src.ExercicioDeFixacao.classesComMain;

import java.util.Scanner;
import ExercicioDeFixacaoClasses.ClasseDoEx02;

public class Exercicio02 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ClasseDoEx02 cl02 = new ClasseDoEx02();

        System.out.print("Nome: ");
        cl02.nome = sc.nextLine();

        System.out.print("Salário Bruto: ");
        cl02.sBruto = sc.nextDouble();

        System.out.print("Imposto: ");
        cl02.imposto = sc.nextDouble();

        System.out.printf("Nome: %s \nSalário Bruto: %.2f \nImposto: %.2f\n", 
                          cl02.nome, cl02.sBruto, cl02.imposto);

        System.out.println("Empregado: " + cl02.nome + ", Salário Líquido: " + cl02.sLiquido());

        System.out.print("Qual porcentagem aumentar o salário? ");
        cl02.porcentagem = sc.nextDouble();

        System.out.println("Atualização salarial: " + cl02.aumento());

        sc.close();
    }
}
