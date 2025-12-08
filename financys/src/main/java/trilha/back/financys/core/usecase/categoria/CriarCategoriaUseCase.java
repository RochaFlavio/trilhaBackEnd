package trilha.back.financys.core.usecase.categoria;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import trilha.back.financys.core.domain.categoria.Categoria;
import trilha.back.financys.core.ports.out.CategoriaRepositoryPort;
import trilha.back.financys.interfaces.dto.DtoCategoria;
import trilha.back.financys.interfaces.mapper.CategoriaMapper;

@Service
public class CriarCategoriaUseCase {

    private final CategoriaRepositoryPort categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CriarCategoriaUseCase(CategoriaRepositoryPort categoriaRepository,
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

