package br.com.repositorio.repo.repo;

import br.com.repositorio.repo.model.Autor;
import br.com.repositorio.repo.model.Livro;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepo extends CrudRepository<Livro, Long> {

}
