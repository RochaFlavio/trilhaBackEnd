package trilha.back.financys.desafio3.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.desafio3.entity.Categoria;
import trilha.back.financys.desafio3.entity.Lancamento;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class controllerLancamento {

    private List<Lancamento> listaL = new ArrayList<Lancamento>();

    @PostMapping
    public ResponseEntity<Integer> incluirCategoria(@RequestBody Lancamento lancamento) {
        listaL.add(lancamento);
        int posicao = listaL.size() - 1;
        return ResponseEntity.status(HttpStatus.CREATED).body(posicao);
    }

    @GetMapping
    public ResponseEntity<List<Lancamento>> listarCategorias() {
        List<Lancamento> ordenados = new ArrayList<>(listaL);
        ordenados.sort(Comparator.comparing(Lancamento::getData));
        return ResponseEntity.ok(ordenados);
    }
//    @GetMapping
//    public ResponseEntity<List<Lancamento>> listarCategorias() {
//        return ResponseEntity.ok(listaL);
//    }
}
