package br.com.repositorio.repo.criaautor;

import br.com.repositorio.repo.model.Autor;
import br.com.repositorio.repo.repo.AutorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ErroEmailRepetidoValidator implements Validator {

    @Autowired
    AutorRepo autorRepo;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoAutorReq.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) return;
        NovoAutorReq req = (NovoAutorReq)target;
        Optional<Autor> autorPossivel = autorRepo.findFirstByEmail(req.getEmail());
        if(autorPossivel.isPresent()){
            errors.rejectValue("email", null, "Já existe um cadastro com esse email");
        }
    }
}
