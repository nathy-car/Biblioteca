package TaskFlow.projeto.repositories;

import TaskFlow.projeto.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LivrosRepository extends JpaRepository<Livro, Long> {
}