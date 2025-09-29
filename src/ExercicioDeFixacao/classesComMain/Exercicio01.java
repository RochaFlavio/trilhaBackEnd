package src.ExercicioDeFixacao.classesComMain;

import java.util.Scanner;
import ExercicioDeFixacaoClasses.ClasseDoEx01;

public class Exercicio01 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ClasseDoEx01 retangulo = new ClasseDoEx01();
        
        System.out.print("Digite a largura: ");
        retangulo.largura = sc.nextDouble();

        System.out.print("Digite a altura: ");
        retangulo.altura = sc.nextDouble();

        System.out.printf("Área: %.2f\n", retangulo.area());
        System.out.printf("Perímetro: %.2f\n", retangulo.perimetro());
        System.out.printf("Diagonal: %.2f\n", retangulo.diagonal());

        sc.close();
    }
}
