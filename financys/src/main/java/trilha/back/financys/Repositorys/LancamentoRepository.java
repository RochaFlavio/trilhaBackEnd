package trilha.back.financys.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import trilha.back.financys.Entitys.Lancamento;

import java.util.List;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

    List<Lancamento> findByPagoTrue();

    List<Lancamento> findByPagoFalse();
}