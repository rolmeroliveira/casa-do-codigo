package br.com.repositorio.repo.config.validacao;

public class ErrosDadosDto {
    private String campo;
    private String erro;

    public ErrosDadosDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
