package trilha.back.financys.application.categoria;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import trilha.back.financys.domain.lancamento.LancamentoRepository;
import trilha.back.financys.domain.categoria.CategoriaRepository;

import java.util.NoSuchElementException;

@Service
public class DeletarCategoriaSeSemLancamentosUseCase {

    private final CategoriaRepository categoriaRepository;
    private final LancamentoRepository lancamentoRepository;

    public DeletarCategoriaSeSemLancamentosUseCase(CategoriaRepository categoriaRepository,
                                                   LancamentoRepository lancamentoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.lancamentoRepository = lancamentoRepository;
    }

    @Transactional
    public void executar(Long id) {

        if (!categoriaRepository.existsById(id)) {
            throw new NoSuchElementException("Categoria com ID " + id + " não encontrada.");
        }

        long vinculados = lancamentoRepository.countByCategoria_Id(id);
        if (vinculados > 0) {
            throw new IllegalStateException(
                    "Categoria não pode ser excluída. Existem " + vinculados + " lançamentos vinculados a ela.");
        }

        categoriaRepository.deleteById(id);
    }
}
