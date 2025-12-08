package trilha.back.financys.application.lancamento;

import org.springframework.stereotype.Service;
import trilha.back.financys.interfaces.dto.DtoLancamento;
import trilha.back.financys.interfaces.mapper.LancamentoMapper.LancamentoMapper;
import trilha.back.financys.domain.lancamento.Lancamento;
import trilha.back.financys.domain.lancamento.LancamentoRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarLancamentosOrdenadosPorDataUseCase {

    private final LancamentoRepository lancamentoRepository;
    private final LancamentoMapper lancamentoMapper;

    public ListarLancamentosOrdenadosPorDataUseCase(LancamentoRepository lancamentoRepository,
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
