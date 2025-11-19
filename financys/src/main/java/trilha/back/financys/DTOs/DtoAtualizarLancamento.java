package trilha.back.financys.DTOs;

public record DtoAtualizarLancamento(Long id, String nome, String descricao, String tipo, Integer quantidade,
                                     String data, Boolean pago, DtoAtualizarCategoria iDCatego) {
}
