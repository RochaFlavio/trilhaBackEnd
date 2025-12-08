package trilha.back.financys.application.categoria;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import trilha.back.financys.interfaces.mapper.CategoriaMapper.CategoriaMapper;
import trilha.back.financys.interfaces.dto.DtoCategoria;
import trilha.back.financys.domain.categoria.Categoria;
import trilha.back.financys.domain.categoria.CategoriaRepository;

import java.util.NoSuchElementException;

@Service
public class AtualizarCategoriaUseCase {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public AtualizarCategoriaUseCase(CategoriaRepository categoriaRepository,
                                     CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    @Transactional
    public DtoCategoria executar(Long id, DtoCategoria dados) {
        var opt = categoriaRepository.findById(id);
        if (opt.isEmpty()) {
            throw new NoSuchElementException("Categoria com ID " + id + " não encontrada.");
        }

        Categoria categoria = opt.get();
        if (dados.nome() != null) categoria.setNome(dados.nome());
        if (dados.descricao() != null) categoria.setDescricao(dados.descricao());

        Categoria atualizado = categoriaRepository.save(categoria);
        return categoriaMapper.toDTO(atualizado);
    }
}
