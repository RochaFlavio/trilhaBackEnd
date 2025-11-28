package trilha.back.financys.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import trilha.back.financys.DTOs.DtoCategoria;
import trilha.back.financys.Services.CategoriaService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    @Transactional
    public ResponseEntity<DtoCategoria> criarCategoria(@RequestBody @Valid DtoCategoria dto) {
        DtoCategoria categoriaSalva = categoriaService.save(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoriaSalva.id())
                .toUri();
        return ResponseEntity.created(location).body(categoriaSalva);
    }

    @GetMapping
    public ResponseEntity<List<DtoCategoria>> listarCategorias() {
        List<DtoCategoria> lista = categoriaService.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoCategoria> buscarPorId(@PathVariable Long id) {
        Optional<DtoCategoria> opt = categoriaService.findById(id);
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/id/{nome}")
    public ResponseEntity<Long> buscarIdPorNome(@PathVariable String nome) {
        Long id = categoriaService.idCategoriaPorNome(nome);
        if (id == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DtoCategoria> atualizarCategoria(@PathVariable Long id, @RequestBody @Valid DtoCategoria dados) {
        var salvo = categoriaService.updateCategoria(id, dados);
        return ResponseEntity.ok(salvo);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deletarCategoria(@PathVariable Long id) {
        if (!categoriaService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        boolean ok = categoriaService.deleteIfNoLancamentos(id);
        if (!ok) {
            return ResponseEntity.status(org.springframework.http.HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.ok("Categoria deletada com sucesso.");
    }
}