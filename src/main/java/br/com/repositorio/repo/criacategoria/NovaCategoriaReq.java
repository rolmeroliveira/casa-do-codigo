package br.com.repositorio.repo.criacategoria;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaReq {
    @NotBlank
    private String nome;

    public NovaCategoriaReq() {
    }

    public NovaCategoriaReq(String nome) {
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


