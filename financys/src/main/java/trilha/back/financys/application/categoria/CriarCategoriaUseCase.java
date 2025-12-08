package trilha.back.financys.application.categoria;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import trilha.back.financys.interfaces.mapper.CategoriaMapper.CategoriaMapper;
import trilha.back.financys.interfaces.dto.DtoCategoria;
import trilha.back.financys.domain.categoria.Categoria;
import trilha.back.financys.domain.categoria.CategoriaRepository;

@Service
public class CriarCategoriaUseCase {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CriarCategoriaUseCase(CategoriaRepository categoriaRepository,
                                 CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    @Transactional
    public DtoCategoria executar(DtoCategoria dto) {
        Categoria entity = categoriaMapper.toEntity(dto);
        Categoria salvo = categoriaRepository.save(entity);
        return categoriaMapper.toDTO(salvo);
    }
}

