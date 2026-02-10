package trilha.back.financys.exception;

public class ListaVaziaException extends RuntimeException {
    public ListaVaziaException() {
        super(" Não existe os dados pelo parâmetro passado ");
    }
}
