package br.com.repositorio.repo.cliente;

import br.com.repositorio.repo.estado.EstadoReq;
import br.com.repositorio.repo.estado.EstadoResp;
import br.com.repositorio.repo.model.Cliente;
import br.com.repositorio.repo.model.Estado;
import br.com.repositorio.repo.repo.ClienteRepo;
import br.com.repositorio.repo.repo.EstadoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteRepo repo;
    @Autowired
    EntityManager em;

    @PostMapping
    public ResponseEntity<ClienteResp> insere(@RequestBody @Valid ClienteReq clienteReq  , UriComponentsBuilder ucb){
            Cliente cliente = clienteReq.requestToModel(em);
            Cliente clienteSalvo = repo.save(cliente);
            ClienteResp clienteResp = new ClienteResp(clienteSalvo);
            URI uri = ucb.path("clientes/{id}").buildAndExpand(clienteResp.getId()).toUri();
            return ResponseEntity.created(uri).body(clienteResp);
    }
}
