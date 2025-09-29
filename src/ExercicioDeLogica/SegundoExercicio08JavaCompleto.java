package ExercicioDeLogica;

import java.util.Scanner;

public class SegundoExercicio08JavaCompleto {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double salario;
		double acrescimo;
		
		salario = sc.nextDouble();
		if (salario <= 2000) {
			System.out.println("Salário de %.2f%n" + salario + " isento de imposto");
		}
		else if (salario >= 2000.01 && salario <= 3000.00) {
			acrescimo = (1000.00 * 0.08);
			System.out.printf("Imposto de: %.2f%nSobre o salário de: %.2f%n",acrescimo , salario);
		}
		else if(salario > 3000.00 && salario <= 4500.00) {
			 acrescimo = (1000.00 * 0.08) + (2.00 *  0.18);
				System.out.printf("Imposto de: %.2f%nSobre o salário de: %.2f%n",acrescimo , salario);
		}
		else {
			acrescimo = (salario - 4500.00) * 0.28 + 1500.0 * 0.18 + 1000.0 * 0.08;
			System.out.printf("Imposto de: %.2f%nSobre o salário de: %.2f%n",acrescimo , salario);
		}
		sc.close();
	}

}
