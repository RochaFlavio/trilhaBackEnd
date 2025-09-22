package ExercicioDeFixacaoClasses;

public class ClasseDoEx03 {

	public String nome;
	public double nota1;
	public double nota2;
	public double nota3;

	public double notaFinal() {
		return nota1 + nota2 + nota3;
	}

	public boolean aprovado() {
		return notaFinal() >= 60.0;
	}

	public double pontosFaltantes() {
		if (aprovado()) {
			return 0.0;
		} else {
			return 60.0 - notaFinal();
		}
	}
}
