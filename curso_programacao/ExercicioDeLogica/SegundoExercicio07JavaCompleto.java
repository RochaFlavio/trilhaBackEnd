package curso_programacao.ExercicioDeLogica;

import java.util.Scanner;

public class SegundoExercicio07JavaCompleto {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x;
		int y;
		
		x = sc.nextInt();
		y = sc.nextInt();
		if (x == 0 && y == 0) {
			System.out.println("Origem");
		}
		else if (x == 0 && y != 0) {
			System.out.println("Eixo Y");
		}
		else if (x != 0 && y == 0) {
			System.out.println("Eixo X");
		}
		else if (x > 0 && y > 0) {
			System.out.println("Q1");
		}
		else if (x < 0 && y > 0) {
			System.out.println("Q2");
		}
		else if (x < 0 && y < 0) {
			System.out.println("Q3");
		}
		else {
			System.out.println("Q4");
		}
		
		sc.close();
	}
	

}
