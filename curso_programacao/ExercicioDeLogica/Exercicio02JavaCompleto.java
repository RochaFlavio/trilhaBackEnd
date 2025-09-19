package curso_programacao.ExercicioDeLogica;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio02JavaCompleto {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		double pi = 3.14159;
		double raio;
		double soma;

		raio = sc.nextDouble();
		soma = pi * raio * raio;

		System.out.println("A = " + soma);

		sc.close();
	}

}
