package trilha.back.financys.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trilha.back.financys.DTOs.CategoriaMapper;
import trilha.back.financys.DTOs.DtoCategoria;
import trilha.back.financys.Entitys.Categoria;
import trilha.back.financys.Repositorys.CategoriaRepository;
import trilha.back.financys.Repositorys.LancamentoRepository;

import java.util.List;
import java.util.Optional;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    public boolean existsById(Long id) {
        return id != null && categoriaRepository.existsById(id);
    }

    public List<DtoCategoria> findAll() {
        return categoriaRepository.findAll().stream().map(categoriaMapper::toDTO).collect(Collectors.toList());
    }

    public Optional<DtoCategoria> findById(Long id) {
        return categoriaRepository.findById(id).map(categoriaMapper::toDTO);
    }

    @Transactional
    public DtoCategoria save(DtoCategoria dto) {
        Categoria entity = categoriaMapper.toEntity(dto);
        Categoria salvo = categoriaRepository.save(entity);
        return categoriaMapper.toDTO(salvo);
    }

    @Transactional
    public DtoCategoria updateCategoria(Long id, DtoCategoria dados) {
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

    @Transactional
    public boolean deleteIfNoLancamentos(Long id) {

        if (!categoriaRepository.existsById(id)) {
            throw new NoSuchElementException("Categoria com ID " + id + " não encontrada.");
        }
        long vinculados = lancamentoRepository.countByCategoria_Id(id);
        if (vinculados > 0) {
            throw new IllegalStateException("Categoria não pode ser excluída. Existem " + vinculados + " lançamentos vinculados a ela.");
        }
        categoriaRepository.deleteById(id);

        return true;
    }


    public long countLancamentosByCategoria(Long id) {
        return lancamentoRepository.countByCategoria_Id(id);
    }

    public Long idCategoriaPorNome(String nome) {
        if (nome == null) return null;
        return categoriaRepository.findByNome(nome).map(Categoria::getId).orElse(null);
    }
}
