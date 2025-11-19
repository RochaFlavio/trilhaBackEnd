package trilha.back.financys.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trilha.back.financys.DTOs.DtoChart;
import trilha.back.financys.DTOs.LancamentoMapper;
import trilha.back.financys.Entitys.Lancamento;
import trilha.back.financys.Entitys.TipoLancamento;
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
        // converte cada Lancamento em DtoChart (via mapper), agrupa por chave (nome + "::" + tipoNome)
        Map<String, BigDecimal> somaPorChave = lancamentoRepository.findAll()
                .stream()
                .map(lancamentoMapper::toDTOChart) // DtoChart deve ter .nome(), .tipo() (enum) e .total()
                .filter(d -> d != null) // só por segurança
                .collect(Collectors.groupingBy(
                        d -> (d.nome() == null ? "SEM_CATEGORIA" : d.nome()) + "::" + (d.tipo() == null ? "SEM_TIPO" : d.tipo().name()),
                        Collectors.mapping(
                                d -> d.total() == null ? BigDecimal.ZERO : d.total(),
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                        )
                ));

        List<DtoChart> resultado = somaPorChave.entrySet()
                .stream()
                .map(e -> {
                    String chave = e.getKey();
                    BigDecimal total = e.getValue() == null ? BigDecimal.ZERO : e.getValue();
                    String[] parts = chave.split("::", 2);
                    String nome = parts.length > 0 ? parts[0] : "SEM_CATEGORIA";
                    String tipoStr = parts.length > 1 ? parts[1] : "SEM_TIPO";

                    TipoLancamento tipoEnum = null;
                    try {
                        if (!"SEM_TIPO".equals(tipoStr)) {
                            tipoEnum = TipoLancamento.valueOf(tipoStr);
                        }
                    } catch (IllegalArgumentException ex) {
                        tipoEnum = null;
                    }

                    return new DtoChart(nome, tipoEnum, total);
                })
                .collect(Collectors.toList());

        return resultado;
    }
}
