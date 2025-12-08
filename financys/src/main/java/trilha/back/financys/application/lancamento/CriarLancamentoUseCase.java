package trilha.back.financys.application.lancamento;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import trilha.back.financys.interfaces.dto.DtoLancamento;
import trilha.back.financys.interfaces.mapper.LancamentoMapper.LancamentoMapper;
import trilha.back.financys.domain.lancamento.LancamentoRepository;

@Service
public class CriarLancamentoUseCase {

    private final LancamentoRepository lancamentoRepository;
    private final LancamentoMapper lancamentoMapper;

    public CriarLancamentoUseCase(LancamentoRepository lancamentoRepository,
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
