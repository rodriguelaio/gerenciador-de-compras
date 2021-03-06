package br.com.guelaio.gerenciadordeestoque.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginDto {

    private String usuario;
    private String senha;

    public LoginDto(String usuario, String senha) {
	setUsuario(usuario);
	setSenha(senha);
    }

    public String getUsuario() {
	return usuario;
    }

    private void setUsuario(String usuario) {
	this.usuario = usuario;
    }

    public String getSenha() {
	return senha;
    }

    private void setSenha(String senha) {
	this.senha = senha;
    }

    public UsernamePasswordAuthenticationToken converter() {
	return new UsernamePasswordAuthenticationToken(usuario, senha);
    }
}
