package curso_programacao.ExercicioDeLogica;

import java.util.Scanner;

public class SegundoExercicio06JavaCompleto {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		
		num = sc.nextInt();
		 if(num < 0) {
			 System.out.println("Número: " + num + " Fora do intevalo");
		 }
		 else if(num <= 25 ) {
			 System.out.println("Número: " + num + " No intevalo {0,25}");
		 }
		 else if (num <= 50) {
			 System.out.println("Número: " + num + " No intevalo {25,50}");
		 }
		 else if (num <= 75) {
			 System.out.println("Número: " + num + " No intevalo {50,75}");
			 }
		 else if (num <= 100) {
			 System.out.println("Número: " + num + " No intevalo {75,100}");
		 	}
		 else {
		 		System.out.println("Número maior que 100. Intervalo não mapeado!");
		 	}
		 sc.close();
		 
	}

}
