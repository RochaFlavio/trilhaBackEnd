package trilha.back.financys.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trilha.back.financys.Entitys.Lancamento;
import trilha.back.financys.Repositorys.CategoriaRepository;
import trilha.back.financys.Repositorys.LancamentoRepository;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class LancamentoService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private CategoriaService categoriaService;

    public boolean validarIdCategoria(Long idCategoria) {
        return idCategoria != null && categoriaRepository.existsById(idCategoria);
    }

    @Transactional
    public Lancamento incluirLancamento(Lancamento lancamento) {
        Long idCat = lancamento.getIdCategoria();
        if (idCat == null || !validarIdCategoria(idCat)) {
            throw new IllegalArgumentException("Categoria inválida ou inexistente (idCategoria=" + idCat + ").");
        }
        return lancamentoRepository.save(lancamento);
    }

    public List<Lancamento> listarTodosOrdenadosPorData() {
        return lancamentoRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Lancamento::getData))
                .collect(Collectors.toList());
    }

    @Transactional
    public Lancamento atualizarLancamento(Long id, Lancamento dados) {
        var opt = lancamentoRepository.findById(id);
        if (opt.isEmpty()) {
            throw new NoSuchElementException("Lançamento com ID " + id + " não encontrado.");
        }
        Lancamento lanc = opt.get();
        Long novoIdCat = dados.getIdCategoria();
        if (novoIdCat != null && !validarIdCategoria(novoIdCat)) {
            throw new IllegalArgumentException("Categoria inválida (id=" + novoIdCat + ").");
        }

        lanc.atualizarLancamento(dados);
        return lancamentoRepository.save(lanc);
    }

    @Transactional
    public void deletarLancamento(Long id) {
        if (!lancamentoRepository.existsById(id)) {
            throw new NoSuchElementException("Lançamento com ID " + id + " não encontrado.");
        }
        lancamentoRepository.deleteById(id);
    }

    public Long idCategoriaPorNome(String nome) {
        return categoriaService.idCategoriaPorNome(nome);
    }
}
