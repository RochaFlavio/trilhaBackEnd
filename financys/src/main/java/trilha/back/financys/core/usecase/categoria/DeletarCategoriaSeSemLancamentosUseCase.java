package trilha.back.financys.core.usecase.categoria;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import trilha.back.financys.core.ports.out.CategoriaRepositoryPort;
import trilha.back.financys.core.ports.out.LancamentoRepositoryPort;

import java.util.NoSuchElementException;

@Service
public class DeletarCategoriaSeSemLancamentosUseCase {

    private final CategoriaRepositoryPort categoriaRepository;
    private final LancamentoRepositoryPort lancamentoRepository;

    public DeletarCategoriaSeSemLancamentosUseCase(CategoriaRepositoryPort categoriaRepository,
                                                   LancamentoRepositoryPort lancamentoRepository) {
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