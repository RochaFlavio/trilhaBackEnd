package trilha.back.financys.DTOs;

import jakarta.validation.constraints.NotNull;

public record DtoAtualizarCategoria(@NotNull Long id, String nome, String descricao) {
}
