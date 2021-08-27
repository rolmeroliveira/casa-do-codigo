package br.com.repositorio.repo.repo;

import br.com.repositorio.repo.model.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoriaRepo extends CrudRepository<Categoria, Long> {
    Optional<Categoria> findFirstByNome(String nome);
}
