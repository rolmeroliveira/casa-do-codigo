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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<LivroSimplificadoResp>> lista(UriComponentsBuilder ucb){
        List<Livro> listaLivros = (List<Livro>) repo.findAll();
        List<LivroSimplificadoResp> ListaSaida = listaLivros.stream().map(l -> new LivroSimplificadoResp(l)).collect(Collectors.toList());
        URI uri = ucb.path("livros").buildAndExpand().toUri();
        return ResponseEntity.created(uri).body(ListaSaida);
    }

    @GetMapping(path = {"/{id}"})
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<LivroResp> retornaUm(@PathVariable Long id, UriComponentsBuilder ucb){
        Optional<Livro> livroEncontrado = repo.findById(id);
        if(livroEncontrado.isPresent()){
            LivroResp livroResp = new LivroResp(livroEncontrado.get());
            URI uri = ucb.path("livros/{id}").buildAndExpand(livroResp.getId()).toUri();
            return ResponseEntity.ok(livroResp);
        }
        return ResponseEntity.badRequest().build();
    }
}
