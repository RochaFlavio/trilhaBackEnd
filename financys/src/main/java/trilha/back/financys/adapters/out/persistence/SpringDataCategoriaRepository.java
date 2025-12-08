package trilha.back.financys.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trilha.back.financys.core.domain.categoria.Categoria;
import trilha.back.financys.core.ports.out.CategoriaRepositoryPort;

import java.util.Optional;

@Repository
public interface SpringDataCategoriaRepository
        extends JpaRepository<Categoria, Long>, CategoriaRepositoryPort {

    @Override
    Optional<Categoria> findByNome(String nome);
}

