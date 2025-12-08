package trilha.back.financys.interfaces.api.LancamentoController;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import trilha.back.financys.interfaces.dto.DtoAtualizarLancamento;
import trilha.back.financys.interfaces.dto.DtoChart;
import trilha.back.financys.interfaces.dto.DtoLancamento;
import trilha.back.financys.application.lancamento.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    private final IncluirLancamentoUseCase incluirLancamentoUseCase;
    private final ListarLancamentosOrdenadosPorDataUseCase listarLancamentosOrdenadosPorDataUseCase;
    private final AtualizarLancamentoUseCase atualizarLancamentoUseCase;
    private final DeletarLancamentoUseCase deletarLancamentoUseCase;
    private final GerarChartPorCategoriaETipoUseCase gerarChartPorCategoriaETipoUseCase;
    private final CalcularMediaUseCase calcularMediaUseCase;

    public LancamentoController(IncluirLancamentoUseCase incluirLancamentoUseCase,
                                ListarLancamentosOrdenadosPorDataUseCase listarLancamentosOrdenadosPorDataUseCase,
                                AtualizarLancamentoUseCase atualizarLancamentoUseCase,
                                DeletarLancamentoUseCase deletarLancamentoUseCase,
                                GerarChartPorCategoriaETipoUseCase gerarChartPorCategoriaETipoUseCase,
                                CalcularMediaUseCase calcularMediaUseCase) {
        this.incluirLancamentoUseCase = incluirLancamentoUseCase;
        this.listarLancamentosOrdenadosPorDataUseCase = listarLancamentosOrdenadosPorDataUseCase;
        this.atualizarLancamentoUseCase = atualizarLancamentoUseCase;
        this.deletarLancamentoUseCase = deletarLancamentoUseCase;
        this.gerarChartPorCategoriaETipoUseCase = gerarChartPorCategoriaETipoUseCase;
        this.calcularMediaUseCase = calcularMediaUseCase;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DtoLancamento> incluirLancamento(@RequestBody @Valid DtoLancamento dto) {
        var salvo = incluirLancamentoUseCase.executar(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(salvo.id())
                .toUri();
        return ResponseEntity.created(location).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<DtoLancamento>> listarLancamentos() {
        var listar = listarLancamentosOrdenadosPorDataUseCase.executar();
        return ResponseEntity.ok(listar);
    }

    @GetMapping("/pagos")
    public ResponseEntity<List<DtoLancamento>> listarPagos() {
        var lista = listarLancamentosOrdenadosPorDataUseCase.executar()
                .stream()
                .filter(l -> l.pago() != null && l.pago())
                .toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/pendentes")
    public ResponseEntity<List<DtoLancamento>> listarPendentes() {
        var lista = listarLancamentosOrdenadosPorDataUseCase.executar()
                .stream()
                .filter(l -> l.pago() == null || !l.pago())
                .toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/chart")
    public ResponseEntity<List<DtoChart>> chartPorCategoriaETipo() {
        var lista = gerarChartPorCategoriaETipoUseCase.executar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/calcula/{x}/{y}")
    public ResponseEntity<Integer> calculaMedia(@PathVariable Integer x, @PathVariable Integer y) {
        Integer resultado = calcularMediaUseCase.executar(x, y);
        return ResponseEntity.ok(resultado);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DtoLancamento> atualizar(@PathVariable Long id,
                                                   @RequestBody DtoAtualizarLancamento dados) {
        var salvo = atualizarLancamentoUseCase.executar(id, dados);
        return ResponseEntity.ok(salvo);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        deletarLancamentoUseCase.executar(id);
        return ResponseEntity.ok("Lançamento excluido com sucesso!");
    }
}
