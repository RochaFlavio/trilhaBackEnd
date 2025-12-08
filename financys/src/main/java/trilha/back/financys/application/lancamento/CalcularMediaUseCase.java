package trilha.back.financys.application.lancamento;

import org.springframework.stereotype.Service;

@Service
public class CalcularMediaUseCase {

    public Integer executar(Integer x, Integer y) {
        if (x == 0 || y == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida.");
        } else if (x < 0 || y < 0) {
            throw new ArithmeticException("Divisão por números negativos não é permitida.");
        }
        return x / y;
    }
}
