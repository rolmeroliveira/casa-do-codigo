package br.com.repositorio.repo.criaautor;
import br.com.repositorio.repo.model.Autor;
import br.com.repositorio.repo.repo.AutorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutoresController {

    @Autowired
    AutorRepo repo;
    @Autowired
    private ErroEmailRepetidoValidator erroEmailRepetidoValidator;



    @InitBinder
    public void initiBinder(WebDataBinder binder){
        binder.addValidators(erroEmailRepetidoValidator);
    }

    @PostMapping
    public String insere(@RequestBody @Valid NovoAutorReq novoAutorReq){
        Autor autor = novoAutorReq.conveterParaModel();
        repo.save(autor);
        return autor.toString();
    }
}
