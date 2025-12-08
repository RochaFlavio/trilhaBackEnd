package trilha.back.financys.domain.lancamento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
    List<Lancamento> findByPagoTrue();
    List<Lancamento> findByPagoFalse();
    long countByCategoria_Id(Long categoriaId);
}