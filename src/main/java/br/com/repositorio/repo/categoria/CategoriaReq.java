package br.com.repositorio.repo.categoria;

import br.com.repositorio.repo.config.validacao.ValorExclusivo;
import br.com.repositorio.repo.model.Autor;
import br.com.repositorio.repo.model.Categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaReq {
    @NotBlank
    @ValorExclusivo(domainClass = Categoria.class, fieldName = "nome", message = "Nome precisa ser exclusivo")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria conveterParaModel(){
        Categoria categoria = new Categoria(this.nome);
        return categoria;
    }

}


