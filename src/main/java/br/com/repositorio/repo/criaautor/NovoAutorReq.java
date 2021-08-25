package br.com.zup.casacodigo.criaautor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorReq {
    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @Size(max = 400)
    private String descricao;

    public NovoAutorReq(@NotBlank String nome, @NotBlank @Email String email, @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor conveterParaModel() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
