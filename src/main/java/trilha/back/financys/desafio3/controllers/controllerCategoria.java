package trilha.back.financys.desafio3.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.desafio3.entity.Categoria;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categorias") //
public class controllerCategoria {

    private List<Categoria> lista = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Integer> criarCategoria(@RequestBody Categoria categoria) {
        lista.add(categoria);
        int posicao = lista.size() - 1;
        return ResponseEntity.status(HttpStatus.CREATED).body(posicao);

    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() {
        return ResponseEntity.ok(lista);
    }
}
