package curso_programacao;

import java.util.Scanner;

public class SegundoExercicio04JavaCompleto {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int hInicial = sc.nextInt();
		int hFinal = sc.nextInt();
		
		int duracao;
		if (hInicial < hFinal) {
			duracao = hFinal - hInicial;
		}
		else {
			duracao = 24 - hInicial + hFinal;
		}
		
		System.out.println("O JOGO DUROU " + duracao + " HORAS!");
		
		sc.close();
			
		}
	}

