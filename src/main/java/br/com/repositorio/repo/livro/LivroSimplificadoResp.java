package br.com.repositorio.repo.livro;
import br.com.repositorio.repo.model.Livro;


public class LivroSimplificadoResp {

    private long id;
    private String título;

    public LivroSimplificadoResp(Livro livro) {
        this.id = livro.getId();
        this.título = livro.getTítulo();
    }

    public long getId() {
        return id;
    }

    public String getTítulo() {
        return título;
    }



    @Override
    public String toString() {
        return "Livro =>" +
                " id=" + id +
                "| título='" + título;
    }
}

