package ExercicioDeLogica;

import java.util.Scanner;

public class Exercicio03JavaCompleto {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A;
		int B;
		int C;
		int D;
		
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		D = sc.nextInt();
		
		int diferenca = (A * B) - (C * D);
		
		System.out.println("DIFERENÇA = " + diferenca);
		
		sc.close();
	}
}
