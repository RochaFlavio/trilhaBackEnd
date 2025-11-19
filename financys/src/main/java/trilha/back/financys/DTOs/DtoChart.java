package trilha.back.financys.DTOs;

import trilha.back.financys.Entitys.TipoLancamento;

import java.math.BigDecimal;

public record DtoChart(String nome, TipoLancamento tipo, BigDecimal total) {
}
