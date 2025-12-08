package trilha.back.financys.core.ports.out;

import trilha.back.financys.core.domain.lancamento.Lancamento;

import java.util.List;
import java.util.Optional;

public interface LancamentoRepositoryPort {

    Lancamento save(Lancamento lancamento);

    Optional<Lancamento> findById(Long id);

    List<Lancamento> findAll();

    boolean existsById(Long id);

    void deleteById(Long id);

    long countByCategoria_Id(Long categoriaId);
}
