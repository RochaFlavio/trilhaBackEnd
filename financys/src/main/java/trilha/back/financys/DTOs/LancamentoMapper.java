package trilha.back.financys.DTOs;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import trilha.back.financys.Entitys.Lancamento;

@Mapper(componentModel = "spring")
public interface LancamentoMapper {

    @Mapping(source = "categoria.nome", target = "nome")
    @Mapping(source = "tipo", target = "tipo")
    @Mapping(source = "valor", target = "total")
    DtoChart toDTOChart(Lancamento lancamento);
}
