package ExercicioWhile;

import java.util.Scanner;

public class ExercicioWhile03 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int alcool = 0;
		int gasolina = 0;
		int diesel = 0;
		int opcao = sc.nextInt();

		while (opcao != 4) {
			if (opcao == 1) {
				alcool += 1;
			} else if (opcao == 2) {
				gasolina += 1;
			} else if (opcao == 3) {
				diesel += 1;
			} else {
				System.out.println("Opção inválida");
			}
			opcao = sc.nextInt();
		}
		System.out.printf("MUITO OBRIGADO \nAlcool: %d \nGasolina: %d \nDiesel: %d"
				,alcool, gasolina, diesel);

		sc.close();
	}

}
