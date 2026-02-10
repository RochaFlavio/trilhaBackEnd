package trilha.back.financys.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import trilha.back.financys.DTOs.DtoAtualizarLancamento;
import trilha.back.financys.DTOs.DtoChart;
import trilha.back.financys.DTOs.DtoFiltro;
import trilha.back.financys.DTOs.DtoLancamento;
import trilha.back.financys.Services.LancamentoService;
import trilha.back.financys.exception.ListaVaziaException;

import java.net.URI;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
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

        if (listar.isEmpty()) {
            throw new ListaVaziaException();
        }

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

    @GetMapping("/filtro")
    public ResponseEntity<List<DtoFiltro>> getLancamentosDependentes(
            @RequestParam(value = "data", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data,
            @RequestParam(value = "quantidade", required = false) Integer quantidade,
            @RequestParam(value = "pago", required = false) Boolean pago
    ) {
        List<DtoFiltro> lista =
                lancamentoService.buscarPorFiltro(data, quantidade, pago);

        if (lista.isEmpty()) {
            throw new ListaVaziaException();
        }


        return ResponseEntity.ok(lista);
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
