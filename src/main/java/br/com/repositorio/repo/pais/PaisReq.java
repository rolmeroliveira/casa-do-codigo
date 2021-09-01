package br.com.repositorio.repo.pais;

import br.com.repositorio.repo.config.validacao.ValorExclusivo;
import br.com.repositorio.repo.model.Pais;

import javax.validation.constraints.NotBlank;

public class PaisReq {
    @NotBlank
    @ValorExclusivo(domainClass = Pais.class, fieldName = "nome", message = "Nome precisa ser exclusivo")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Pais  conveterParaModel(){
        Pais pais = new Pais(this.nome);
        return pais;
    }

}
