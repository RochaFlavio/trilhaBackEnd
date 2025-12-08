package trilha.back.financys.core.usecase.lancamento;

import org.springframework.stereotype.Service;
import trilha.back.financys.core.domain.lancamento.Lancamento;
import trilha.back.financys.core.ports.out.LancamentoRepositoryPort;
import trilha.back.financys.interfaces.dto.DtoLancamento;
import trilha.back.financys.interfaces.mapper.LancamentoMapper;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarLancamentosOrdenadosPorDataUseCase {

    private final LancamentoRepositoryPort lancamentoRepository;
    private final LancamentoMapper lancamentoMapper;

    public ListarLancamentosOrdenadosPorDataUseCase(LancamentoRepositoryPort lancamentoRepository,
                                                    LancamentoMapper lancamentoMapper) {
        this.lancamentoRepository = lancamentoRepository;
        this.lancamentoMapper = lancamentoMapper;
    }

    public List<DtoLancamento> executar() {
        return lancamentoRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Lancamento::getData))
                .map(lancamentoMapper::toDto)
                .collect(Collectors.toList());
    }
}
