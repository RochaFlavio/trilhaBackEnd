package ExercicioFor;

import java.util.Scanner;

public class ExercicioFor03 {
	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);

	        int N = sc.nextInt(); 

	        for (int i = 0; i < N; i++) {
	            double v1 = sc.nextDouble();
	            double v2 = sc.nextDouble();
	            double v3 = sc.nextDouble();

	            double media = (v1 * 2 + v2 * 3 + v3 * 5) / 10.0;

	            System.out.printf("%.1f%n", media);
	        }

	        sc.close();
	}

}
