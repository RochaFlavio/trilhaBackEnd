package trilha.back.financys.application.lancamento;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trilha.back.financys.interfaces.dto.DtoAtualizarLancamento;
import trilha.back.financys.interfaces.dto.DtoLancamento;
import trilha.back.financys.interfaces.mapper.LancamentoMapper.LancamentoMapper;
import trilha.back.financys.domain.categoria.Categoria;
import trilha.back.financys.domain.categoria.CategoriaRepository;
import trilha.back.financys.domain.lancamento.Lancamento;
import trilha.back.financys.domain.lancamento.LancamentoRepository;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@Service
public class AtualizarLancamentoUseCase {

    private final LancamentoRepository lancamentoRepository;
    private final CategoriaRepository categoriaRepository;
    private final LancamentoMapper lancamentoMapper;

    public AtualizarLancamentoUseCase(LancamentoRepository lancamentoRepository,
                                      CategoriaRepository categoriaRepository,
                                      LancamentoMapper lancamentoMapper) {
        this.lancamentoRepository = lancamentoRepository;
        this.categoriaRepository = categoriaRepository;
        this.lancamentoMapper = lancamentoMapper;
    }

    @Transactional
    public DtoLancamento executar(Long id, DtoAtualizarLancamento dto) {
        var opt = lancamentoRepository.findById(id);
        if (opt.isEmpty()) {
            throw new NoSuchElementException("Lançamento com ID " + id + " não encontrado.");
        }

        Lancamento lanc = opt.get();

        Long novoIdCat = dto.iDCatego() != null ? dto.iDCatego().id() : null;
        if (novoIdCat != null && !categoriaRepository.existsById(novoIdCat)) {
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
            Categoria c = categoriaRepository.findById(novoIdCat)
                    .orElseThrow(() -> new IllegalArgumentException("Categoria inválida."));
            lanc.setCategoria(c);
        }

        Lancamento salvo = lancamentoRepository.save(lanc);
        return lancamentoMapper.toDto(salvo);
    }
}

