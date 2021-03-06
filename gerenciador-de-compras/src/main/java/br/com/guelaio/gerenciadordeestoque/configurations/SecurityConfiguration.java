package br.com.guelaio.gerenciadordeestoque.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.guelaio.gerenciadordeestoque.repositories.UsuarioRepository;
import br.com.guelaio.gerenciadordeestoque.services.TokenService;
import br.com.guelaio.gerenciadordeestoque.services.implementations.CustomUserDetailsServiceImplementation;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CustomUserDetailsServiceImplementation customUserDetailsService;

//    @Autowired
//    public SecurityConfiguration(TokenService tokenService, UsuarioRepository usuarioRepository,
//	    CustomUserDetailsServiceImplementation customUserDetailsService) {
//	this.tokenService = tokenService;
//	this.usuarioRepository = usuarioRepository;
//	this.customUserDetailsService = customUserDetailsService;
//    }

    // NECESSÁRIO PARA FAZER A INJECAO DE DEPENDENCIA O AuthenticationManager no
    // CONTROLLER
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
	return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests().antMatchers(HttpMethod.POST, "/auth").permitAll().anyRequest().authenticated().and()
		.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)// A SESSAO
													    // SERÁ
													    // STATELESS,
													    // POIS SERÁ
													    // VIA JWT,
													    // ENTRETANDO
													    // SERÁ
													    // NECESSÁRIO
													    // CRIAR UM
													    // CONTROLLER
													    // PARA
													    // AUTENTICACAO
		.and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, usuarioRepository),
			UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
	web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**",
		"/swagger-resources/**", "/h2-console/**");
    }

}
