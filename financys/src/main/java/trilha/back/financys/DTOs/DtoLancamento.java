package trilha.back.financys.DTOs;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import trilha.back.financys.Entitys.TipoLancamento;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DtoLancamento(
        Long id,

        @NotBlank(message = "Nome não pode ser nulo ou vazio")
        @Size(min = 3, max = 45, message = "O nome deve ter entre 3 e 45 caracteres")
        String nome,

        @NotBlank(message = "Descrição não pode ser nula ou vazia")
        @Size(min = 15, max = 150, message = "A descrição deve ter entre 15 e 150 caracteres")
        String descricao,

        @NotNull(message = "Tipo não pode ser nulo")
        @Enumerated(EnumType.STRING)
        @Column(name = "tipo")
        TipoLancamento tipo,

        @NotNull(message = "Quantidade não pode ser nula")
        @PositiveOrZero(message = "A quantidade não pode ser negativa")
        Integer quantidade,

        @NotNull(message = "Data não pode ser nula")
        LocalDate data,

        @NotNull(message = "Campo 'pago' não pode ser nulo")
        Boolean pago,

        @NotNull(message = "idCategoria é obrigatório")
        Long idCategoria,

        @PositiveOrZero(message = "O valor não pode ser negativo")
        BigDecimal valor
) {
}