package trilha.back.financys.application.lancamento;

import org.springframework.stereotype.Service;
import trilha.back.financys.interfaces.dto.DtoChart;
import trilha.back.financys.interfaces.mapper.LancamentoMapper.LancamentoMapper;
import trilha.back.financys.domain.lancamento.LancamentoRepository;
import trilha.back.financys.domain.lancamento.TipoLancamento;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class GerarChartPorCategoriaETipoUseCase {

    private final LancamentoRepository lancamentoRepository;
    private final LancamentoMapper lancamentoMapper;

    public GerarChartPorCategoriaETipoUseCase(LancamentoRepository lancamentoRepository,
                                              LancamentoMapper lancamentoMapper) {
        this.lancamentoRepository = lancamentoRepository;
        this.lancamentoMapper = lancamentoMapper;
    }

    public List<DtoChart> executar() {
        Map<String, BigDecimal> somaPorChave = lancamentoRepository.findAll()
                .stream()
                .map(lancamentoMapper::toDTOChart)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        d -> (d.nome() == null ? "SEM_CATEGORIA" : d.nome()) +
                                "::" +
                                (d.tipo() == null ? "SEM_TIPO" : d.tipo().name()),
                        Collectors.mapping(
                                d -> d.total() == null ? BigDecimal.ZERO : d.total(),
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                        )
                ));

        return somaPorChave.entrySet()
                .stream()
                .map(e -> {
                    String chave = e.getKey();
                    BigDecimal total = e.getValue() == null ? BigDecimal.ZERO : e.getValue();
                    String[] parts = chave.split("::", 2);
                    String nome = parts.length > 0 ? parts[0] : "SEM_CATEGORIA";
                    String tipoStr = parts.length > 1 ? parts[1] : "SEM_TIPO";

                    TipoLancamento tipoEnum = null;
                    try {
                        if (!"SEM_TIPO".equals(tipoStr)) {
                            tipoEnum = TipoLancamento.valueOf(tipoStr);
                        }
                    } catch (IllegalArgumentException ex) {
                        tipoEnum = null;
                    }

                    return new DtoChart(nome, tipoEnum, total);
                })
                .collect(Collectors.toList());
    }
}

