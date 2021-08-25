package br.com.repositorio.repo.config.validacao;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;

public class FabricaDeBinders implements WebDataBinderFactory {
    @Override
    public WebDataBinder createBinder(NativeWebRequest webRequest, Object target, String objectName) throws Exception {
        return null;
    }
}
