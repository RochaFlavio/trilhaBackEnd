package ExercicioDeLogica;

import java.util.Scanner;

public class SegundoExercicio03JavaCompleto {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1;
		int num2;
		
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		if(num1 % num2 == 0) {
			System.out.println("Os números: " + num1 + " e "+ num2 + " são multiplos.");
		}else {
			System.out.println("Os números: " + num1 + " e "+ num2 + " não multiplos.");
		}
		
		sc.close();
	}
}
