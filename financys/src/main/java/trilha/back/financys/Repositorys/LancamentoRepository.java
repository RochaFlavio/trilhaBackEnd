package trilha.back.financys.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import trilha.back.financys.DTOs.DtoFiltro;
import trilha.back.financys.DTOs.DtoLancamento;
import trilha.back.financys.Entitys.Lancamento;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

    long countByCategoria_Id(Long categoriaId);

    List<Lancamento> findByPagoTrue();

    List<Lancamento> findByPagoFalse();

    List<DtoFiltro> findByDataAndQuantidadeAndPago(LocalDate data, Integer quantidade, Boolean pago);
}