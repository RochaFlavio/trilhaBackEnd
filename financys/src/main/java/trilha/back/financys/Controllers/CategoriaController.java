package trilha.back.financys.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.Entitys.Categoria;
import trilha.back.financys.Repositorys.CategoriaRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> criarCategoria(@RequestBody @Valid Categoria categoria) {
        var categoriaSalva = repository.save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() {
        var lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizarCategoria(@PathVariable Long id, @RequestBody Categoria dados) {
        Optional<Categoria> categoriaOpt = repository.findById(id);
        if (categoriaOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria com ID " + id + " não encontrada.");
        }

        Categoria categoria = categoriaOpt.get();
        if (dados.getNome() != null) categoria.setNome(dados.getNome());
        if (dados.getDescricao() != null) categoria.setDescricao(dados.getDescricao());

        repository.save(categoria);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarCategoria(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Categoria com ID " + id + " não encontrada.");
        }
        repository.deleteById(id);
        return ResponseEntity.ok("Categoria deletada com sucesso.");
    }
}
