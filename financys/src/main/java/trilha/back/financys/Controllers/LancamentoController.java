package trilha.back.financys.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import trilha.back.financys.DTOs.DtoAtualizarLancamento;
import trilha.back.financys.DTOs.DtoChart;
import trilha.back.financys.DTOs.DtoLancamento;
import trilha.back.financys.Services.LancamentoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DtoLancamento> incluirLancamento(@RequestBody @Valid DtoLancamento dto) {
        var salvo = lancamentoService.incluirLancamento(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(salvo.id())
                .toUri();
        return ResponseEntity.created(location).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<DtoLancamento>> listarLancamentos() {
        var listar = lancamentoService.listarTodosOrdenadosPorData();
        return ResponseEntity.ok(listar);
    }

    @GetMapping("/pagos")
    public ResponseEntity<List<DtoLancamento>> listarPagos() {
        var lista = lancamentoService.listarTodosOrdenadosPorData()
                .stream().filter(l -> l.pago() != null && l.pago()).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/pendentes")
    public ResponseEntity<List<DtoLancamento>> listarPendentes() {
        var lista = lancamentoService.listarTodosOrdenadosPorData()
                .stream().filter(l -> l.pago() == null || !l.pago()).toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/chart")
    public ResponseEntity<List<DtoChart>> chartPorCategoriaETipo() {
        var lista = lancamentoService.gerarChartPorCategoriaETipo();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/calcula/{x}/{y}")
    public ResponseEntity<Integer> calculaMedia(@PathVariable Integer x, @PathVariable Integer y) {

        Integer resultado = x / y;
        return ResponseEntity.ok(resultado);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DtoLancamento> atualizar(@PathVariable Long id, @RequestBody DtoAtualizarLancamento dados) {
        var salvo = lancamentoService.atualizarLancamento(id, dados);
        return ResponseEntity.ok(salvo);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        lancamentoService.deletarLancamento(id);
        return ResponseEntity.ok("Lançamento excluido com sucesso!");
    }
}
