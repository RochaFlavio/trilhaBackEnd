package ExercicioFor;

import java.util.Scanner;

public class ExercicioFor02 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); 

		int dentro = 0;
		int fora = 0;

		for (int i = 0; i < N; i++) {
			int X = sc.nextInt(); 
			if (X >= 10 && X <= 20) {
				dentro++;
			} else {
				fora++;
			}
		}

		System.out.println(dentro + " in");
		System.out.println(fora + " out");

		sc.close();
	}

}
