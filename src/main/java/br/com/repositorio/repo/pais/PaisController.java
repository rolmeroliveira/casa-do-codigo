package br.com.repositorio.repo.pais;

import br.com.repositorio.repo.categoria.CategoriaReq;
import br.com.repositorio.repo.categoria.CategoriaResp;
import br.com.repositorio.repo.categoria.ErroNomeRepetidoCategoriaValidator;
import br.com.repositorio.repo.model.Categoria;
import br.com.repositorio.repo.model.Pais;
import br.com.repositorio.repo.repo.CategoriaRepo;
import br.com.repositorio.repo.repo.PaisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    PaisRepo repo;

    @PostMapping
    public ResponseEntity<PaisResp> insere(@RequestBody @Valid PaisReq paisReq, UriComponentsBuilder ucb){
        Pais pais  = paisReq.conveterParaModel();
        Pais paisSalvo = repo.save(pais);
        PaisResp paisResp = new PaisResp(paisSalvo);
        URI uri = ucb.path("paises/{id}").buildAndExpand(paisResp.getId()).toUri();
        return ResponseEntity.created(uri).body(paisResp);
    }
}
