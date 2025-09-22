package ExercicioDeFixacaoClasses;

public class ClasseDoEx02 {
	
	public String nome;
	public double sBruto;
	public double imposto;
	public double porcentagem;
	
	public double sLiquido() {
		return sBruto - imposto;
	}
	
	public double aumento() {
		double aumento = sBruto * (porcentagem / 100);
		return (sBruto + aumento) - imposto;
	};
	
	

}
