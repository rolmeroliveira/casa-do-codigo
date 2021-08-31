package br.com.repositorio.repo.categoria;

import br.com.repositorio.repo.model.Categoria;
import br.com.repositorio.repo.repo.CategoriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ErroNomeRepetidoCategoriaValidator implements Validator {

    @Autowired
    CategoriaRepo repo;

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaReq.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) return;
        CategoriaReq req = (CategoriaReq)target;
        Optional<Categoria> categoriaPossivel = repo.findFirstByNome(req.getNome());
        if(categoriaPossivel.isPresent()){
            errors.rejectValue("nome", null, "Já uma categoria com esse nome");
        }
    }
}
