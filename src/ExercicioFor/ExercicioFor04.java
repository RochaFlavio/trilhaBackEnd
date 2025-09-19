package ExercicioFor;

import java.util.Scanner;

public class ExercicioFor04 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			double n1 = sc.nextDouble();
			double n2 = sc.nextDouble();
			if (n1 == 0) {
				System.out.println("Divisão impossivel");
			} else {
				double divisao = (double) n1 / n2;
				System.out.printf("%.1f%n", divisao);
			}
		}
		sc.close();
	}
}
