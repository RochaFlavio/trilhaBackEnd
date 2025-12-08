package trilha.back.financys.interfaces.api.CategoriaController;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import trilha.back.financys.interfaces.dto.DtoCategoria;
import trilha.back.financys.application.categoria.*;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CriarCategoriaUseCase criarCategoriaUseCase;
    private final ListarCategoriasUseCase listarCategoriasUseCase;
    private final BuscarCategoriaPorIdUseCase buscarCategoriaPorIdUseCase;
    private final BuscarIdCategoriaPorNomeUseCase buscarIdCategoriaPorNomeUseCase;
    private final AtualizarCategoriaUseCase atualizarCategoriaUseCase;
    private final DeletarCategoriaSeSemLancamentosUseCase deletarCategoriaSeSemLancamentosUseCase;

    public CategoriaController(CriarCategoriaUseCase criarCategoriaUseCase,
                               ListarCategoriasUseCase listarCategoriasUseCase,
                               BuscarCategoriaPorIdUseCase buscarCategoriaPorIdUseCase,
                               BuscarIdCategoriaPorNomeUseCase buscarIdCategoriaPorNomeUseCase,
                               AtualizarCategoriaUseCase atualizarCategoriaUseCase,
                               DeletarCategoriaSeSemLancamentosUseCase deletarCategoriaSeSemLancamentosUseCase) {
        this.criarCategoriaUseCase = criarCategoriaUseCase;
        this.listarCategoriasUseCase = listarCategoriasUseCase;
        this.buscarCategoriaPorIdUseCase = buscarCategoriaPorIdUseCase;
        this.buscarIdCategoriaPorNomeUseCase = buscarIdCategoriaPorNomeUseCase;
        this.atualizarCategoriaUseCase = atualizarCategoriaUseCase;
        this.deletarCategoriaSeSemLancamentosUseCase = deletarCategoriaSeSemLancamentosUseCase;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DtoCategoria> criarCategoria(@RequestBody @Valid DtoCategoria dto) {
        DtoCategoria categoriaSalva = criarCategoriaUseCase.executar(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoriaSalva.id())
                .toUri();
        return ResponseEntity.created(location).body(categoriaSalva);
    }

    @GetMapping
    public ResponseEntity<List<DtoCategoria>> listarCategorias() {
        List<DtoCategoria> lista = listarCategoriasUseCase.executar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoCategoria> buscarPorId(@PathVariable Long id) {
        Optional<DtoCategoria> opt = buscarCategoriaPorIdUseCase.executar(id);
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/id/{nome}")
    public ResponseEntity<Long> buscarIdPorNome(@PathVariable String nome) {
        Long id = buscarIdCategoriaPorNomeUseCase.executar(nome);
        if (id == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DtoCategoria> atualizarCategoria(@PathVariable Long id,
                                                           @RequestBody @Valid DtoCategoria dados) {
        DtoCategoria salvo = atualizarCategoriaUseCase.executar(id, dados);
        return ResponseEntity.ok(salvo);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deletarCategoria(@PathVariable Long id) {
        try {
            deletarCategoriaSeSemLancamentosUseCase.executar(id);
            return ResponseEntity.ok("Categoria deletada com sucesso.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
