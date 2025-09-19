package ExercicioDeLogica;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio04JavaCompleto {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		String numFunc; 
		double horasT;
		double valorH;
		double salary;
		
		numFunc= sc.next();
		horasT = sc.nextDouble();
		valorH = sc.nextDouble();
		salary = horasT * valorH;
		
		
		System.out.printf("Number = %s%nSalary = %.2f%n", numFunc, salary);

		
		sc.close();

	}
}
