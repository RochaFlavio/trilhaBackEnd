package trilha.back.financys.application.categoria;

import org.springframework.stereotype.Service;
import trilha.back.financys.interfaces.mapper.CategoriaMapper.CategoriaMapper;
import trilha.back.financys.interfaces.dto.DtoCategoria;
import trilha.back.financys.domain.categoria.CategoriaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarCategoriasUseCase {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public ListarCategoriasUseCase(CategoriaRepository categoriaRepository,
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

