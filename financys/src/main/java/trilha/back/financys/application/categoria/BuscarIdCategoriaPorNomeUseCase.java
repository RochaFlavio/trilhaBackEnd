package trilha.back.financys.application.categoria;

import org.springframework.stereotype.Service;
import trilha.back.financys.domain.categoria.Categoria;
import trilha.back.financys.domain.categoria.CategoriaRepository;

@Service
public class BuscarIdCategoriaPorNomeUseCase {

    private final CategoriaRepository categoriaRepository;

    public BuscarIdCategoriaPorNomeUseCase(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Long executar(String nome) {
        if (nome == null) return null;
        return categoriaRepository.findByNome(nome)
                .map(Categoria::getId)
                .orElse(null);
    }
}