package br.com.zup.casacodigo.criaautor;

import br.com.zup.casacodigo.repo.AutorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutoresController {

    @Autowired
    AutorRepo repo;

    @PostMapping
    public String insere(@RequestBody @Valid NovoAutorReq novoAutorReq){
        Autor autor = novoAutorReq.conveterParaModel();
        repo.save(autor);
        return autor.toString();
    }
}
