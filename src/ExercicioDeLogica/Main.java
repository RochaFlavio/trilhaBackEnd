package ExercicioDeLogica;

import java.util.Locale;

public class Main {
	
	public static void main(String[] args) {
	
		String product1 = "Computer";
		String product2 = "Office desk";
		
		int age =30;
		int code = 5290;
		char gender = 'F';
		
		double price1 = 2100.0;
		double price2 = 650.50;
		double measure = 53.234567;
		
		System.out.println("Products:\n" + product1 + 
				"which price is  $" + price1+ 
				"\n" + product2 +", whitch price is $ " 
				+ price2 + "\n\n");
		
		System.out.printf("Record: %d years old, code %d"
				+ "and gender: %s", age, code, gender);
//		System.out.printf("\n\nMeasue with eight decimal places: " +
//		measure + "\nRouded (three decimal places): " + "%3 fmeasure", measure);
		
		System.out.printf("\n\nMeasure with eight decimal places: "
				+ "%.8f%nRounded (three decimal places): %.3f%n", measure, measure);

		Locale.setDefault(Locale.US);
		System.out.printf("US decimal point: %.3f%n", measure);
		
		
	}
	

}

