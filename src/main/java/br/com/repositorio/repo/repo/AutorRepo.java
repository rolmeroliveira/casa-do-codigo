package br.com.repositorio.repo.repo;

import br.com.repositorio.repo.criaautor.Autor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AutorRepo extends CrudRepository<Autor, Long> {

    //usei findFirst porque já havia dados duplicados no banco de teste
    //Não estava trazendo registro unico
    Optional<Autor> findFirstByEmail(String email);
}
