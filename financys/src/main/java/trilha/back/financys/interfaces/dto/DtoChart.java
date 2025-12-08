package trilha.back.financys.interfaces.dto;

import trilha.back.financys.core.domain.lancamento.TipoLancamento;

import java.math.BigDecimal;

public record DtoChart(String nome, TipoLancamento tipo, BigDecimal total) {
}
