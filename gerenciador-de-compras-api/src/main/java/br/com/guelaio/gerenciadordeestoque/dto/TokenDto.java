package br.com.guelaio.gerenciadordeestoque.dto;

public class TokenDto {

    private String token;
    private String tipo;

    public TokenDto(String token, String tipo) {
	setToken(token);
	setTipo(tipo);
    }

    public String getToken() {
	return token;
    }

    private void setToken(String token) {
	this.token = token;
    }

    public String getTipo() {
	return tipo;
    }

    private void setTipo(String tipo) {
	this.tipo = tipo;
    }

}
