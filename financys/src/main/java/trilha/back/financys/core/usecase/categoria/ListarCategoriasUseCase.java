package trilha.back.financys.core.usecase.categoria;

import org.springframework.stereotype.Service;
import trilha.back.financys.core.ports.out.CategoriaRepositoryPort;
import trilha.back.financys.interfaces.dto.DtoCategoria;
import trilha.back.financys.interfaces.mapper.CategoriaMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarCategoriasUseCase {

    private final CategoriaRepositoryPort categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public ListarCategoriasUseCase(CategoriaRepositoryPort categoriaRepository,
                                   CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    public List<DtoCategoria> executar() {
        return categoriaRepository.findAll()
                .stream()
                .map(categoriaMapper::toDTO)
                .collect(Collectors.toList());
    }
}

