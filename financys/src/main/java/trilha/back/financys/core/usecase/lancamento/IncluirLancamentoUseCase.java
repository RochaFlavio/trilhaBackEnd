package trilha.back.financys.core.usecase.lancamento;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import trilha.back.financys.core.domain.categoria.Categoria;
import trilha.back.financys.core.domain.lancamento.Lancamento;
import trilha.back.financys.core.ports.out.CategoriaRepositoryPort;
import trilha.back.financys.core.ports.out.LancamentoRepositoryPort;
import trilha.back.financys.interfaces.dto.DtoLancamento;
import trilha.back.financys.interfaces.mapper.LancamentoMapper;

@Service
public class IncluirLancamentoUseCase {

    private final CategoriaRepositoryPort categoriaRepository;
    private final LancamentoRepositoryPort lancamentoRepository;
    private final LancamentoMapper lancamentoMapper;

    public IncluirLancamentoUseCase(CategoriaRepositoryPort categoriaRepository,
                                    LancamentoRepositoryPort lancamentoRepository,
                                    LancamentoMapper lancamentoMapper) {
        this.categoriaRepository = categoriaRepository;
        this.lancamentoRepository = lancamentoRepository;
        this.lancamentoMapper = lancamentoMapper;
    }

    @Transactional
    public DtoLancamento executar(DtoLancamento dto) {
        Long idCat = dto.idCategoria();
        Categoria categoria = categoriaRepository.findById(idCat)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Categoria inválida ou inexistente (idCategoria=" + idCat + ")."));

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
}