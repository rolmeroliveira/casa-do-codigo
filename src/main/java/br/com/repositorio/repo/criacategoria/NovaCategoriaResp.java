package br.com.repositorio.repo.criacategoria;

import br.com.repositorio.repo.config.validacao.UniqueValue;
import br.com.repositorio.repo.model.Categoria;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaResp {
    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "O valor deste campo não pode ser repetido")
    private String nome;

    public NovaCategoriaResp() {
    }

    public NovaCategoriaResp(String nome) {
        this.nome = nome;
    }


    public String getNome() {
        return nome;
    }

    public Categoria conveterParaModel(){
        Categoria categoria = new Categoria(this.nome);
        return categoria;
    }

}


