package trilha.back.financys.interfaces.dto;

import trilha.back.financys.core.domain.lancamento.TipoLancamento;

import java.math.BigDecimal;

public record DtoAtualizarLancamento(Long id, String nome, String descricao, TipoLancamento tipo, Integer quantidade,
                                     String data, Boolean pago, DtoAtualizarCategoria iDCatego, BigDecimal valor) {
}
