package curso_programacao.ExercicioDeLogica;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio06JavaCompleto {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		double triangulo, circulo, 
		trapezio, quadrado, retangulo;
		
		double A, B, C;
		
		double pi = 3.14159;
		
		A = sc.nextDouble();
		B = sc.nextDouble();
		C = sc.nextDouble();
		
		triangulo = A * C / 2;
		circulo = pi * C * C;
		trapezio = (A + B) * C / 2;
		quadrado = B * B;
		retangulo =  A * B;
		
		System.out.printf("TRIANGULO: %.3f%n \nCIRCULO: %.3f%n"
				+ "\nTRAPEZIO: %.3f%n \nQUADRADO: %.3f%n \nRETANGULO: %.3f%n",
				triangulo, circulo, trapezio, quadrado, retangulo);
		
		sc.close();
	}

}
