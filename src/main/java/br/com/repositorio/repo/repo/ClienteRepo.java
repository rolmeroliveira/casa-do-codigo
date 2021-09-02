package br.com.repositorio.repo.repo;

import br.com.repositorio.repo.model.Cliente;
import org.springframework.data.repository.CrudRepository;



public interface ClienteRepo extends CrudRepository<Cliente, Long> {

}
