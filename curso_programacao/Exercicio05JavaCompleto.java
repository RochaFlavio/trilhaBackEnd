package curso_programacao;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio05JavaCompleto {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		int codPeca, codPeca2;
		int quantPeca, quantPeca2;
		double valorPeca, valorPeca2;
		double valorPagar;
		
		codPeca = sc.nextInt();
		quantPeca = sc.nextInt();
		valorPeca = sc.nextDouble();
		
		codPeca2 = sc.nextInt();
		quantPeca2 = sc.nextInt();
		valorPeca2 = sc.nextDouble();
		
		valorPagar = (quantPeca * valorPeca) + 
				 (quantPeca2 * valorPeca2);
		
		System.out.printf("VALOR A PAGAR: R$ %.2f%n", valorPagar);
		
		sc.close();
		
		
	}

}
