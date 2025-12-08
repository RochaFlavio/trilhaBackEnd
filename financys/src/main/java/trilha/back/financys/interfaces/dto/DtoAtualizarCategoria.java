package trilha.back.financys.interfaces.dto;

import jakarta.validation.constraints.NotNull;

public record DtoAtualizarCategoria(@NotNull Long id, String nome, String descricao) {
}
