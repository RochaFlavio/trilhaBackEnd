package trilha.back.financys.application.lancamento;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import trilha.back.financys.domain.lancamento.LancamentoRepository;

import java.util.NoSuchElementException;

@Service
public class DeletarLancamentoUseCase {

    private final LancamentoRepository lancamentoRepository;

    public DeletarLancamentoUseCase(LancamentoRepository lancamentoRepository) {
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
