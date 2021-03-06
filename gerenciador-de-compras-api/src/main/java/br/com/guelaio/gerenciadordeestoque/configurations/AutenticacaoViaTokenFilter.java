package br.com.guelaio.gerenciadordeestoque.configurations;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.guelaio.gerenciadordeestoque.models.Usuario;
import br.com.guelaio.gerenciadordeestoque.repositories.UsuarioRepository;
import br.com.guelaio.gerenciadordeestoque.services.TokenService;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;
    private UsuarioRepository usuarioRepository;

    public AutenticacaoViaTokenFilter(TokenService tokenService, UsuarioRepository usuarioRepository) {
	this.tokenService = tokenService;
	this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
	    FilterChain filterChain) throws ServletException, IOException {
	String token = recuperarToken(httpServletRequest);
	boolean valido = tokenService.isTokenValido(token);

	if (valido)
	    autenticarCliente(token);

	filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private String recuperarToken(HttpServletRequest httpServletRequest) {
	String token = httpServletRequest.getHeader("Authorization");
	if (Objects.isNull(token) || token.isEmpty() || !token.startsWith("Bearer "))
	    return null;
	return token.substring(7);
    }

    private void autenticarCliente(String token) {
	Long idUsuario = tokenService.getIdUsuario(token);
	Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(RuntimeException::new);
	List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
	List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
	UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null,
		usuario.isAdmin() ? authorityListAdmin : authorityListUser);

	// CONSIDERE QUE EST?? AUTENTICADO
	SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
