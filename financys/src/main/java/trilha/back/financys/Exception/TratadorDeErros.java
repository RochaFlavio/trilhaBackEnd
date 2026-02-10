package trilha.back.financys.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> tratarErro404() {
        return ResponseEntity.status(404).body("Recurso não encontrado!.");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DadosErroValidacao>> tratarErrosValidacao(MethodArgumentNotValidException ex) {
        List<DadosErroValidacao> erros = ex.getFieldErrors()
                .stream()
                .map(f -> new DadosErroValidacao(
                        f.getField(),
                        f.getDefaultMessage()
                ))
                .toList();
        return ResponseEntity.badRequest().body(erros);
    }

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<String> tratarErroRegraDeNegocio(ValidationException ex) {
        return ResponseEntity.badRequest().body("Erro de validação!.");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<DadosErroValidacao>> tratarConstraintViolation(ConstraintViolationException ex) {
        var erros = ex.getConstraintViolations()
                .stream()
                .map(cv -> new DadosErroValidacao(
                        cv.getPropertyPath().toString(),
                        "Requisição/Json com corpo inválido!."
                ))
                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(erros);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<String> tratarJsonInvalido(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body("Parâmetro Json ou Url inválido! ");
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class, MissingServletRequestParameterException.class})
    public ResponseEntity<String> tratarParametrosInvalidos(Exception ex) {
        return ResponseEntity.badRequest().body("Parâmetros inválidos ou não encontrado!.");
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> tratarViolacaoIntegridade(DataIntegrityViolationException ex) {
        return ResponseEntity.status(409).body("Violação de integridade!.");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<String> metodoNaoSuportado(HttpRequestMethodNotSupportedException ex) {
        return ResponseEntity.status(405).body("Método HTTP não mapeado ou inválido!.");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> tratarErro500(Exception ex) {
        return ResponseEntity.status(500).body("Erro Interno do Servidor: servidor encontrou uma condição inesperada.");
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> tratarErroNegocio(IllegalStateException ex) {
        return ResponseEntity.status(400).body(ex.getMessage());
    }

    @ExceptionHandler(ListaVaziaException.class)
    public ResponseEntity<String> ListVoid(ListaVaziaException ex) {
        return ResponseEntity.noContent().build();
    }

    private record DadosErroValidacao(String campo, String mensagem) {
        public DadosErroValidacao(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}