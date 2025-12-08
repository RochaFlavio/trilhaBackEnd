package trilha.back.financys.core.usecase.lancamento;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import trilha.back.financys.core.ports.out.LancamentoRepositoryPort;
import trilha.back.financys.interfaces.dto.DtoLancamento;
import trilha.back.financys.interfaces.mapper.LancamentoMapper;

@Service
public class CriarLancamentoUseCase {

    private final LancamentoRepositoryPort lancamentoRepository;
    private final LancamentoMapper lancamentoMapper;

    public CriarLancamentoUseCase(LancamentoRepositoryPort lancamentoRepository,
                                  LancamentoMapper lancamentoMapper) {
        this.lancamentoRepository = lancamentoRepository;
        this.lancamentoMapper = lancamentoMapper;
    }

    @Transactional
    public DtoLancamento executar(DtoLancamento dto) {
        var entity = lancamentoMapper.toEntity(dto);
        var salvo  = lancamentoRepository.save(entity);
        return lancamentoMapper.toDto(salvo);
    }
}
