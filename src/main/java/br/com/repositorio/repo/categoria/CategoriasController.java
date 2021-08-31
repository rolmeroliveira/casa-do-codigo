package br.com.repositorio.repo.categoria;

import br.com.repositorio.repo.model.Categoria;
import br.com.repositorio.repo.repo.CategoriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    CategoriaRepo repo;

    /**
     * @apiNote Apesar de existir um validador universal, conservei esta validação
     * aqui, para registrar este jeito particular e específico de fazer validação
     * Nao subistitua pela validação universal, para não perder a referência de estudo
     */
    @Autowired
    private ErroNomeRepetidoCategoriaValidator erroNomeRepetidoCategoriaValidator;

    /**
     *
     * @apiNote conecta o validador à incialização deste controller
     */
    @InitBinder
    public void initiBinder(WebDataBinder binder){
        binder.addValidators(erroNomeRepetidoCategoriaValidator);
    }

    @PostMapping
    public ResponseEntity<CategoriaResp> insere(@RequestBody @Valid CategoriaReq novaCategoriaReq, UriComponentsBuilder ucb){
        Categoria categoria = novaCategoriaReq.conveterParaModel();
        Categoria CategriaSalva = repo.save(categoria);
        CategoriaResp novaCategoriaRes = new CategoriaResp(CategriaSalva);
        URI uri = ucb.path("categorias/{id}").buildAndExpand(novaCategoriaRes.getId()).toUri();
        return ResponseEntity.created(uri).body(novaCategoriaRes);
    }
}
