package trilha.back.financys.interfaces.mapper.LancamentoMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import trilha.back.financys.domain.lancamento.Lancamento;
import trilha.back.financys.interfaces.dto.DtoChart;
import trilha.back.financys.interfaces.dto.DtoLancamento;

@Mapper(componentModel = "spring")
public interface LancamentoMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nome", target = "nome"),
            @Mapping(source = "descricao", target = "descricao"),
            @Mapping(source = "tipo", target = "tipo"),
            @Mapping(source = "quantidade", target = "quantidade"),
            @Mapping(source = "data", target = "data"),
            @Mapping(source = "pago", target = "pago"),
            @Mapping(source = "categoria.id", target = "idCategoria"),
            @Mapping(source = "valor", target = "valor")
    })
    DtoLancamento toDto(Lancamento lancamento);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nome", target = "nome"),
            @Mapping(source = "descricao", target = "descricao"),
            @Mapping(source = "tipo", target = "tipo"),
            @Mapping(source = "quantidade", target = "quantidade"),
            @Mapping(source = "data", target = "data"),
            @Mapping(source = "pago", target = "pago"),
            @Mapping(source = "idCategoria", target = "categoria.id"),
            @Mapping(source = "valor", target = "valor")
    })
    Lancamento toEntity(DtoLancamento dto);

    @Mapping(source = "categoria.nome", target = "nome")
    @Mapping(source = "tipo", target = "tipo")
    @Mapping(source = "valor", target = "total")
    DtoChart toDTOChart(Lancamento lancamento);
}
