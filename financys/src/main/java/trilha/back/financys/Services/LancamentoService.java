package trilha.back.financys.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trilha.back.financys.DTOs.*;
import trilha.back.financys.Entitys.Categoria;
import trilha.back.financys.Entitys.Lancamento;
import trilha.back.financys.Entitys.TipoLancamento;
import trilha.back.financys.Repositorys.CategoriaRepository;
import trilha.back.financys.Repositorys.LancamentoRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
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
    public DtoLancamento incluirLancamento(DtoLancamento dto) {
        Long idCat = dto.idCategoria();
        var categoria = categoriaRepository.findById(idCat)
                .orElseThrow(() -> new IllegalArgumentException("Categoria inválida ou inexistente (idCategoria=" + idCat + ")."));

        Lancamento lanc = new Lancamento();
        lanc.setNome(dto.nome());
        lanc.setDescricao(dto.descricao());
        lanc.setTipo(dto.tipo());
        lanc.setQuantidade(dto.quantidade());
        lanc.setData(dto.data());
        lanc.setPago(dto.pago());
        lanc.setValor(dto.valor());
        lanc.setCategoria(categoria);

        Lancamento salvo = lancamentoRepository.save(lanc);
        return lancamentoMapper.toDto(salvo);
    }

    public List<DtoLancamento> listarTodosOrdenadosPorData() {

        List<Lancamento> lancamentos = lancamentoRepository.findAll();

        return lancamentos.stream()
                .sorted(Comparator.comparing(Lancamento::getData))
                .map(lancamentoMapper::toDto)
                .collect(Collectors.toList());
    }


    @Transactional
    public DtoLancamento atualizarLancamento(Long id, DtoAtualizarLancamento dto) {
        var opt = lancamentoRepository.findById(id);
        if (opt.isEmpty()) {
            throw new NoSuchElementException("Lançamento com ID " + id + " não encontrado.");
        }
        Lancamento lanc = opt.get();

        Long novoIdCat = dto.iDCatego() != null ? dto.iDCatego().id() : null;
        if (novoIdCat != null && !validarIdCategoria(novoIdCat)) {
            throw new IllegalArgumentException("Categoria inválida (id=" + novoIdCat + ").");
        }

        if (dto.nome() != null) lanc.setNome(dto.nome());
        if (dto.descricao() != null) lanc.setDescricao(dto.descricao());
        if (dto.tipo() != null) lanc.setTipo(dto.tipo());
        if (dto.quantidade() != null) lanc.setQuantidade(dto.quantidade());
        if (dto.data() != null) lanc.setData(LocalDate.parse(dto.data()));
        if (dto.pago() != null) lanc.setPago(dto.pago());
        if (dto.valor() != null) lanc.setValor(dto.valor());
        if (novoIdCat != null) {
            Categoria c = categoriaRepository.findById(novoIdCat).orElseThrow(() -> new IllegalArgumentException("Categoria inválida."));
            lanc.setCategoria(c);
        }

        Lancamento salvo = lancamentoRepository.save(lanc);
        return lancamentoMapper.toDto(salvo);
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
        Map<String, BigDecimal> somaPorChave = lancamentoRepository.findAll()
                .stream()
                .map(lancamentoMapper::toDTOChart)
                .filter(Objects::nonNull)
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

    public Integer calcularMedia(Integer x, Integer y) {
        if (x == 0 || y == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida.");
        } else if (x < 0 || y < 0) {
            throw new ArithmeticException("Divisão por números negativos não são permitidos.");
        }
        return (x / y);
    }

    public List<DtoFiltro> buscarPorFiltro(LocalDate data, Integer quantidade, Boolean pago) {
        List<Lancamento> todos = lancamentoRepository.findAll();

        return todos.stream()
                .filter(l -> (data == null || l.getData().equals(data)) &&
                        (quantidade == null || l.getQuantidade().equals(quantidade)) &&
                        (pago == null || l.getPago().equals(pago)))
                .map(l -> new DtoFiltro(
                        l.getData(),
                        l.getQuantidade(),
                        l.getPago()
                ))
                .toList();
    }
}