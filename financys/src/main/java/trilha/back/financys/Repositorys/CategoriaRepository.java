package trilha.back.financys.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import trilha.back.financys.Entitys.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
