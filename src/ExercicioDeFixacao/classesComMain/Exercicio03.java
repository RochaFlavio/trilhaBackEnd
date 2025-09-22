package src.ExercicioDeFixacao.classesComMain;

import java.util.Locale;
import java.util.Scanner;

import ExercicioDeFixacaoClasses.ClasseDoEx03;

public class Exercicio03 {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		ClasseDoEx03 aluno = new ClasseDoEx03();

		System.out.print("Nome do aluno: ");
		aluno.nome = sc.nextLine();

		System.out.println("Digite as três notas do aluno:");
		aluno.nota1 = sc.nextDouble();
		aluno.nota2 = sc.nextDouble();
		aluno.nota3 = sc.nextDouble();

		System.out.printf("Nota final = %.2f%n", aluno.notaFinal());

		if (aluno.aprovado()) {
			System.out.println("APROVADO!");
		} else {
			System.out.println("REPROVADO!");
			System.out.printf("FALTARAM %.2f PONTOS%n", aluno.pontosFaltantes());
		}

		sc.close();
	}

}
