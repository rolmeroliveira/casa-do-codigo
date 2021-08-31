package br.com.repositorio.repo.autor;
import br.com.repositorio.repo.model.Autor;
import br.com.repositorio.repo.repo.AutorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autores")
public class AutoresController {

    @Autowired
    AutorRepo repo;

    @PostMapping
    public ResponseEntity<AutorResp> insere(@RequestBody @Valid AutorReq novoAutorReq, UriComponentsBuilder ucb){
        Autor autor = novoAutorReq.conveterParaModel();
        Autor autorSalvo = repo.save(autor);
        AutorResp novoAutorResp = new AutorResp(autorSalvo);
        URI uri = ucb.path("autores/{id}").buildAndExpand(novoAutorResp.getId()).toUri();
        return ResponseEntity.created(uri).body(novoAutorResp);
    }
}
