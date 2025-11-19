package trilha.back.financys.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import trilha.back.financys.Entitys.Categoria;
import trilha.back.financys.Services.CategoriaService;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> criarCategoria(@RequestBody @Valid Categoria categoria) {
        var categoriaSalva = categoriaService.save(categoria);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoriaSalva.getId())
                .toUri();
        return ResponseEntity.created(location).body(categoriaSalva);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() {
        var lista = categoriaService.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Categoria> opt = categoriaService.findById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Categoria com ID " + id + " não encontrada.");
        }
        return ResponseEntity.ok(opt.get());
    }

    @GetMapping("/id/{nome}")
    public ResponseEntity<?> buscarIdPorNome(@PathVariable String nome) {
        Long id = categoriaService.idCategoriaPorNome(nome);

        if (id == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Categoria '" + nome + "' não encontrada.");
        }

        return ResponseEntity.ok(id);
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizarCategoria(@PathVariable Long id, @RequestBody Categoria dados) {
        try {
            var salvo = categoriaService.updateCategoria(id, dados);
            return ResponseEntity.ok(salvo);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarCategoria(@PathVariable Long id) {
        if (!categoriaService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Categoria com ID " + id + " não encontrada.");
        }

        boolean ok = categoriaService.deleteIfNoLancamentos(id);
        if (!ok) {
            // já sabemos que existem lançamentos vinculados
            long vinculados = categoriaService.countLancamentosByCategoria(id);
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Não é possível excluir: existem " + vinculados + " lançamento(s) vinculados.");
        }

        return ResponseEntity.ok("Categoria deletada com sucesso.");
    }
}