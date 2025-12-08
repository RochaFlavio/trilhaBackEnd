package trilha.back.financys.core.ports.out;

import trilha.back.financys.core.domain.categoria.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepositoryPort {

    Categoria save(Categoria categoria);

    Optional<Categoria> findById(Long id);

    List<Categoria> findAll();

    boolean existsById(Long id);

    Optional<Categoria> findByNome(String nome);

    void deleteById(Long id);
}
