package trilha.back.financys.exception;

public class ListaVaziaException extends RuntimeException {
    public ListaVaziaException() {
        super("A lista está vazia !");
    }
}
