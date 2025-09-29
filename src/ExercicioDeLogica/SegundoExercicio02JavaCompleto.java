package ExercicioDeLogica;

import java.util.Scanner;

public class SegundoExercicio02JavaCompleto {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		
		num = sc.nextInt();
		
		if(num % 2 == 0) {
			System.out.println("Número digitado: " + num + " é par");
		}else {
			System.out.println("Número digitado: " + num + " é impar");
		}
		
		sc.close();
	}

}
