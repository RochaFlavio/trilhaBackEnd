package trilha.back.financys.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trilha.back.financys.Entitys.Categoria;
import trilha.back.financys.Repositorys.CategoriaRepository;
import trilha.back.financys.Repositorys.LancamentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public boolean existsById(Long id) {
        return id != null && categoriaRepository.existsById(id);
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Transactional
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Transactional
    public Categoria updateCategoria(Long id, Categoria dados) {
        var opt = categoriaRepository.findById(id);
        if (opt.isEmpty()) {
            throw new java.util.NoSuchElementException("Categoria com ID " + id + " não encontrada.");
        }
        Categoria categoria = opt.get();
        if (dados.getNome() != null) categoria.setNome(dados.getNome());
        if (dados.getDescricao() != null) categoria.setDescricao(dados.getDescricao());
        return categoriaRepository.save(categoria);
    }

    @Transactional
    public boolean deleteIfNoLancamentos(Long id) {
        if (!categoriaRepository.existsById(id)) return false;
        long vinculados = lancamentoRepository.countByCategoria_Id(id);
        if (vinculados > 0) {
            return false;
        }
        categoriaRepository.deleteById(id);
        return true;
    }

    public long countLancamentosByCategoria(Long id) {
        return lancamentoRepository.countByCategoria_Id(id);
    }

    public Long idCategoriaPorNome(String nome) {
        if (nome == null) return null;
        return categoriaRepository.findByNome(nome)
                .map(Categoria::getId)
                .orElse(null);
    }
}
