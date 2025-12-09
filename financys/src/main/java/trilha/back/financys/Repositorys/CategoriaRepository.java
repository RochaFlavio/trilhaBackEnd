package trilha.back.financys.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import trilha.back.financys.Entitys.Categoria;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findByNome(String nome);
}