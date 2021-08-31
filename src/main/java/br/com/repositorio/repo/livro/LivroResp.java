package br.com.repositorio.repo.livro;
import br.com.repositorio.repo.model.Autor;
import br.com.repositorio.repo.model.Categoria;
import br.com.repositorio.repo.model.Livro;


public class LivroResp {

    private long id;
    private String título;
    private String resumo;
    private String sumario;
    private double preco;
    private Integer numeroDePaginas;
    private String isbn;
    private String dataDapublicacao;
    private Categoria categoria;
    private Autor autor;


    public LivroResp(Livro livro) {
        this.id = livro.getId();
        this.título = livro.getTítulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.isbn = livro.getIsbn();
        this.dataDapublicacao = livro.getDataDapublicacao().toString();
        this.categoria = livro.getCategoria();
        this.autor = livro.getAutor();
    }



    public long getId() {
        return id;
    }

    public String getTítulo() {
        return título;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public double getPreco() {
        return preco;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDataDapublicacao() {
        return dataDapublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "NovoLivroResp{" +
                "id=" + id +
                ", título='" + título + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numeroDePaginas=" + numeroDePaginas +
                ", isbn='" + isbn + '\'' +
                ", dataDapublicacao=" + dataDapublicacao +
                ", categoria=" + categoria.getNome() +
                ", autor=" + autor.getNome() +
                '}';
    }
}

