package trilha.back.financys.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trilha.back.financys.DTOs.DtoChart;
import trilha.back.financys.DTOs.LancamentoMapper;
import trilha.back.financys.Entitys.Lancamento;
import trilha.back.financys.Repositorys.CategoriaRepository;
import trilha.back.financys.Repositorys.LancamentoRepository;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LancamentoService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private LancamentoMapper lancamentoMapper;

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

    public List<DtoChart> gerarChartPorCategoriaETipo() {
        List<Lancamento> lancamentos = lancamentoRepository.findAll();

        // chave composta: nomeCategoria + "::" + tipo (evite colisões com separador único)
        Map<String, BigDecimal> somaPorChave = new HashMap<>();
        Map<String, String> chaveParaNome = new HashMap<>();
        Map<String, String> chaveParaTipo = new HashMap<>();

        for (Lancamento l : lancamentos) {
            String nomeCategoria = (l.getCategoria() != null && l.getCategoria().getNome() != null)
                    ? l.getCategoria().getNome()
                    : "SEM_CATEGORIA";
            String tipo = (l.getTipo() != null) ? l.getTipo().toString() : "SEM_TIPO";
            BigDecimal valor = (l.getValor() != null) ? l.getValor() : BigDecimal.ZERO;

            String chave = nomeCategoria + "::" + tipo;

            somaPorChave.merge(chave, valor, BigDecimal::add);
            chaveParaNome.put(chave, nomeCategoria);
            chaveParaTipo.put(chave, tipo);
        }

        List<DtoChart> resultado = new ArrayList<>();
        for (Map.Entry<String, BigDecimal> e : somaPorChave.entrySet()) {
            String chave = e.getKey();
            BigDecimal total = e.getValue();
            String nome = chaveParaNome.get(chave);
            String tipo = chaveParaTipo.get(chave);
            resultado.add(new DtoChart(nome, tipo, total));
        }

        return resultado;
    }
}
