package br.com.repositorio.repo.estado;

import br.com.repositorio.repo.model.Estado;
import br.com.repositorio.repo.model.Pais;
import br.com.repositorio.repo.repo.EstadoRepo;
import br.com.repositorio.repo.repo.PaisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.naming.directory.InvalidAttributesException;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    EstadoRepo repo;
    @Autowired
    EntityManager em;

    @PostMapping
    public ResponseEntity<EstadoResp> insere(@RequestBody @Valid EstadoReq estadoReq  , UriComponentsBuilder ucb){

            Estado estado = estadoReq.conveterParaModel();
            Estado estadoSalvo = repo.save(estado);
            EstadoResp estadoResp = new EstadoResp(estadoSalvo);
            URI uri = ucb.path("estados/{id}").buildAndExpand(estadoResp.getId()).toUri();
            return ResponseEntity.created(uri).body(estadoResp);
    }
}
