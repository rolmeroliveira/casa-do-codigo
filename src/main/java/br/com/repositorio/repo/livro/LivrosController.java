package br.com.repositorio.repo.livro;

import br.com.repositorio.repo.model.Livro;
import br.com.repositorio.repo.repo.LivroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    @Autowired
    LivroRepo repo;
    @Autowired
    EntityManager em;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<LivroResp> insere(@RequestBody @Valid LivroReq novoLivorReq, UriComponentsBuilder ucb){
        Livro livro  = novoLivorReq.formToModel(em);
        Livro livroSalvo = repo.save(livro);
        LivroResp novoLivroResp = new LivroResp(livroSalvo);
        URI uri = ucb.path("livros/{id}").buildAndExpand(novoLivroResp.getId()).toUri();
        return ResponseEntity.created(uri).body(novoLivroResp);
    }
}
