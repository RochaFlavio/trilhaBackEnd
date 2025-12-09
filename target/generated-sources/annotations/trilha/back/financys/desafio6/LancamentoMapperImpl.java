package trilha.back.financys.desafio6;

import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import trilha.back.financys.desafio3.entity.Categoria;
import trilha.back.financys.desafio3.entity.Lancamento;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-18T19:43:52-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class LancamentoMapperImpl implements LancamentoMapper {

    @Override
    public Lancamento toEntity(DTOlancamento dto) {
        if ( dto == null ) {
            return null;
        }

        Lancamento lancamento = new Lancamento();

        lancamento.setCategoria( idToCategoria( dto.idCategoria() ) );
        lancamento.setValor( dto.valor() );
        lancamento.setNome( dto.nome() );
        lancamento.setDescricao( dto.descricao() );
        lancamento.setTipo( dto.tipo() );
        lancamento.setQuantidade( dto.quantidade() );
        lancamento.setData( dto.data() );
        lancamento.setPago( dto.pago() );

        return lancamento;
    }

    @Override
    public DTOchart toDTOChart(Lancamento lancamento) {
        if ( lancamento == null ) {
            return null;
        }

        String nome = null;
        String tipo = null;
        BigDecimal total = null;

        nome = lancamentoCategoriaNome( lancamento );
        tipo = lancamento.getTipo();
        total = lancamento.getValor();

        DTOchart dTOchart = new DTOchart( nome, tipo, total );

        return dTOchart;
    }

    private String lancamentoCategoriaNome(Lancamento lancamento) {
        if ( lancamento == null ) {
            return null;
        }
        Categoria categoria = lancamento.getCategoria();
        if ( categoria == null ) {
            return null;
        }
        String nome = categoria.getNome();
        if ( nome == null ) {
            return null;
        }
        return nome;
    }
}
