package trilha.back.financys.core.usecase.lancamento;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import trilha.back.financys.core.ports.out.LancamentoRepositoryPort;

import java.util.NoSuchElementException;

@Service
public class DeletarLancamentoUseCase {

    private final LancamentoRepositoryPort lancamentoRepository;

    public DeletarLancamentoUseCase(LancamentoRepositoryPort lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    @Transactional
    public void executar(Long id) {
        if (!lancamentoRepository.existsById(id)) {
            throw new NoSuchElementException("Lançamento com ID " + id + " não encontrado.");
        }
        lancamentoRepository.deleteById(id);
    }
}
