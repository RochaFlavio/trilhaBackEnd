package trilha.back.financys.Controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import trilha.back.financys.Entitys.Categoria;
import trilha.back.financys.Entitys.Lancamento;
import trilha.back.financys.Repositorys.CategoriaRepository;
import trilha.back.financys.Repositorys.LancamentoRepository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> criarLancamento(@RequestBody @Valid Map<String, Object> dados) {
        try {
            Long id_Categoria = ((Number) dados.get("id_Categoria")).longValue();

            Categoria categoriaOpt = categoriaRepository.findById(id_Categoria)
                    .orElseThrow(() -> new IllegalArgumentException("Categoria com ID " + id_Categoria + " não existe."));

            Lancamento lancamento = new Lancamento();
            lancamento.setNome((String) dados.get("nome"));
            lancamento.setDescricao((String) dados.get("descricao"));
            lancamento.setTipo((String) dados.get("tipo"));
            lancamento.setQuantidade((Integer) dados.get("quantidade"));
            lancamento.setData(LocalDate.parse((String) dados.get("data")));
            lancamento.setPago((Boolean) dados.get("pago"));
            lancamento.setCategoria(categoriaOpt);

            Lancamento salvo = repository.save(lancamento);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar lançamento, ID de categoria não encontrado ou inexistente! ");
        }
    }

    @GetMapping
    public ResponseEntity<List<Lancamento>> listarLancamentos() {
        List<Lancamento> lista = repository.findAll();
        lista.sort(Comparator.comparing(Lancamento::getData));
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/pagos")
    public ResponseEntity<List<Lancamento>> listarPagos() {
        List<Lancamento> lista = repository.findByPagoTrue();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/pendentes")
    public ResponseEntity<List<Lancamento>> listarPendentes(){
        List<Lancamento> lista = repository.findByPagoFalse();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizarLancamento(@PathVariable Long id, @RequestBody Map<String, Object> body) {
        Optional<Lancamento> lancOpt = repository.findById(id);
        if (lancOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Lançamento com ID " + id + " não encontrado.");
        }

        Lancamento lanc = lancOpt.get();

        if (body.containsKey("id_Categoria")) {
            Long idCategoria = ((Number) body.get("id_Categoria")).longValue();
            Optional<Categoria> categoriaOpt = categoriaRepository.findById(idCategoria);
            if (categoriaOpt.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Categoria com ID " + idCategoria + " não existe.");
            }
            lanc.setCategoria(categoriaOpt.get());
        }

        if (body.containsKey("nome")) lanc.setNome((String) body.get("nome"));
        if (body.containsKey("descricao")) lanc.setDescricao((String) body.get("descricao"));
        if (body.containsKey("tipo")) lanc.setTipo((String) body.get("tipo"));
        if (body.containsKey("quantidade")) lanc.setQuantidade((Integer) body.get("quantidade"));
        if (body.containsKey("data")) lanc.setData(java.time.LocalDate.parse((String) body.get("data")));
        if (body.containsKey("pago")) lanc.setPago((Boolean) body.get("pago"));

        repository.save(lanc);
        return ResponseEntity.ok(lanc);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarLancamento(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Lançamento com ID " + id + " não encontrado.");
        }
        repository.deleteById(id);
        return ResponseEntity.ok("Lançamento deletado com sucesso.");
    }
}