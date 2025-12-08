package trilha.back.financys.application.categoria;

import org.springframework.stereotype.Service;
import trilha.back.financys.interfaces.mapper.CategoriaMapper.CategoriaMapper;
import trilha.back.financys.interfaces.dto.DtoCategoria;
import trilha.back.financys.domain.categoria.CategoriaRepository;

import java.util.Optional;

@Service
public class BuscarCategoriaPorIdUseCase {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public BuscarCategoriaPorIdUseCase(CategoriaRepository categoriaRepository,
                                       CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    public Optional<DtoCategoria> executar(Long id) {
        return categoriaRepository.findById(id).map(categoriaMapper::toDTO);
    }
}

