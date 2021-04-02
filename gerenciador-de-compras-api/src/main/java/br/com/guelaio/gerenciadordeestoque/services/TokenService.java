package br.com.guelaio.gerenciadordeestoque.services;

import org.springframework.security.core.Authentication;

public interface TokenService {
    
    String gerarToken(Authentication authentication);

    boolean isTokenValido(String token);

    Long getIdUsuario(String token);
}
