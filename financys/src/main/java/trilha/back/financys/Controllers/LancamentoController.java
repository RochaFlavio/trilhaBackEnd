package trilha.back.financys.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import trilha.back.financys.Entitys.Lancamento;
import trilha.back.financys.Services.LancamentoService;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @PostMapping
    @Transactional
    public ResponseEntity<Object> incluirLancamento(@RequestBody @Valid Lancamento lancamento) {
        try {
            var salvo = lancamentoService.incluirLancamento(lancamento);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(salvo.getId())
                    .toUri();
            return ResponseEntity.created(location).body(salvo);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Lancamento>> listarLancamentos() {
        var listar = lancamentoService.listarTodosOrdenadosPorData();
        return ResponseEntity.ok(listar);
    }

    @GetMapping("/pagos")
    public ResponseEntity<List<Lancamento>> listarPagos() {
        // se preferir, delegue ao service também (mantive simples)
        return ResponseEntity.ok(lancamentoService.listarTodosOrdenadosPorData()
                .stream().filter(Lancamento::getPago).toList());
    }

    @GetMapping("/pendentes")
    public ResponseEntity<List<Lancamento>> listarPendentes() {
        return ResponseEntity.ok(lancamentoService.listarTodosOrdenadosPorData()
                .stream().filter(l -> l.getPago() == null || !l.getPago()).toList());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> atualizar(@PathVariable Long id, @RequestBody Lancamento dados) {
        try {
            var salvo = lancamentoService.atualizarLancamento(id, dados);
            return ResponseEntity.ok(salvo);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        try {
            lancamentoService.deletarLancamento(id);
            return ResponseEntity.ok("Lançamento excluído com sucesso.");
        } catch (NoSuchElementException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}