package trilha.back.financys.interfaces.mapper.CategoriaMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import trilha.back.financys.domain.categoria.Categoria;
import trilha.back.financys.interfaces.dto.DtoCategoria;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "descricao", target = "descricao")
    Categoria toEntity(DtoCategoria dto);

    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "descricao", target = "descricao")
    DtoCategoria toDTO(Categoria categoria);
}