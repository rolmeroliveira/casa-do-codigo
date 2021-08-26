package br.com.repositorio.repo.criacategoria;

import br.com.repositorio.repo.repo.CategoriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    CategoriaRepo repo;
    @Autowired
    private ErroNomeRepetidoCategoriaValidator erroNomeRepetidoCategoriaValidator;

    @InitBinder
    public void initiBinder(WebDataBinder binder){
        binder.addValidators(erroNomeRepetidoCategoriaValidator);
    }

    @PostMapping
    public String insere(@RequestBody @Valid NovaCategoriaReq novaCategoriaReq){
        Categoria categoria = novaCategoriaReq.conveterParaModel();
        repo.save(categoria);
        return categoria.toString();
    }
}
