package trilha.back.financys.core.usecase.categoria;

import org.springframework.stereotype.Service;
import trilha.back.financys.core.ports.out.CategoriaRepositoryPort;
import trilha.back.financys.interfaces.dto.DtoCategoria;
import trilha.back.financys.interfaces.mapper.CategoriaMapper;

import java.util.Optional;

@Service
public class BuscarCategoriaPorIdUseCase {

    private final CategoriaRepositoryPort categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public BuscarCategoriaPorIdUseCase(CategoriaRepositoryPort categoriaRepository,
                                       CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    public Optional<DtoCategoria> executar(Long id) {
        return categoriaRepository.findById(id).map(categoriaMapper::toDTO);
    }
}

