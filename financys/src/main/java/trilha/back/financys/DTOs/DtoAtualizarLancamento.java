package trilha.back.financys.DTOs;

import trilha.back.financys.Entitys.TipoLancamento;

public record DtoAtualizarLancamento(Long id, String nome, String descricao, TipoLancamento tipo, Integer quantidade,
                                     String data, Boolean pago, DtoAtualizarCategoria iDCatego) {
}
