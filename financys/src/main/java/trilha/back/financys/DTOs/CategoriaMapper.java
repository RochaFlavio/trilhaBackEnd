package trilha.back.financys.DTOs;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import trilha.back.financys.Entitys.Categoria;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "descricao", target = "descricao")
    Categoria toEntity(trilha.back.financys.DTOs.DtoCategoria dto);

    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "descricao", target = "descricao")
    DtoCategoria toDTO(Categoria categoria);
}