package trilha.back.financys.desafio7;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import trilha.back.financys.desafio3.entity.Categoria;
import trilha.back.financys.desafio6.DTOcategoria;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-18T19:43:52-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public Categoria toEntity(DTOcategoria dto) {
        if ( dto == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setNome( dto.nome() );
        categoria.setDescricao( dto.descricao() );

        return categoria;
    }

    @Override
    public DTOcategoria toDTO(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        String nome = null;
        String descricao = null;

        nome = categoria.getNome();
        descricao = categoria.getDescricao();

        DTOcategoria dTOcategoria = new DTOcategoria( nome, descricao );

        return dTOcategoria;
    }
}
