package trilha.back.financys.DTOs;

import java.time.LocalDate;

public record DtoFiltro(LocalDate data, Integer quantidade, Boolean pago) {
}
