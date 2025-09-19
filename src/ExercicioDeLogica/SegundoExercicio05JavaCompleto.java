package ExercicioDeLogica;

import java.util.Scanner;

public class SegundoExercicio05JavaCompleto {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);

		int cod = sc.nextInt();
		int qtd = sc.nextInt();
		
		double total;
		if (cod == 1) {
			total = qtd * 4.0;
			System.out.printf(qtd + " - Cachorro Quente. Valor a pagar: %.2f%n", total);
		}
		else if (cod == 2) {
			total = qtd * 4.5;
			System.out.printf(qtd + " - X-Salada. Valor a pagar: %.2f%n", total);
		}
		else if (cod == 3) {
			total = qtd * 5.0;
			System.out.printf(qtd + " - X-Bacon. Valor a pagar: %.2f%n", total);
		}
		else if (cod == 4) {
			total = qtd * 2.0;
			System.out.printf(qtd + " - Torrada simples. Valor a pagar: %.2f%n", total);
		}
		else if (cod == 5){
			total = qtd * 1.5;
			System.out.printf(qtd + " - Refrigerante. Valor a pagar: %.2f%n", total);
			}
		else {
			System.out.println("Item não encontrado");
		}
		
		sc.close();
		
		}
	
}
