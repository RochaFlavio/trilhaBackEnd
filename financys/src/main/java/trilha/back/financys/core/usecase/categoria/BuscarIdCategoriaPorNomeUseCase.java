package trilha.back.financys.core.usecase.categoria;

import org.springframework.stereotype.Service;
import trilha.back.financys.core.domain.categoria.Categoria;
import trilha.back.financys.core.ports.out.CategoriaRepositoryPort;

@Service
public class BuscarIdCategoriaPorNomeUseCase {

    private final CategoriaRepositoryPort categoriaRepository;

    public BuscarIdCategoriaPorNomeUseCase(CategoriaRepositoryPort categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Long executar(String nome) {
        if (nome == null) return null;
        return categoriaRepository.findByNome(nome)
                .map(Categoria::getId)
                .orElse(null);
    }
}