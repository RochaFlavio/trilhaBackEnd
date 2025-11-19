package trilha.back.financys.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DtoCategoria
        (@NotBlank(message = "Nome não pode ser Nulo ou Vazio")
         @Size(min = 3, max = 15, message = "O nome deve ter entre 3 e 15 caracteres." ) String nome,

         @NotBlank(message = "descrição não pode ser Nulo ou Vazio")
         @Size(min = 15, max = 50, message = "A descriçãp deve ter entre 15 e 50 caracteres.") String descricao)
{

}