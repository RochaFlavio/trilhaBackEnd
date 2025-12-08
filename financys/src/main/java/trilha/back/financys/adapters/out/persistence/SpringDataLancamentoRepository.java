package trilha.back.financys.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.financys.core.domain.lancamento.Lancamento;
import trilha.back.financys.core.ports.out.LancamentoRepositoryPort;

@Repository
public interface SpringDataLancamentoRepository
        extends JpaRepository<Lancamento, Long>, LancamentoRepositoryPort {

    @Override
    long countByCategoria_Id(Long categoriaId);
}
