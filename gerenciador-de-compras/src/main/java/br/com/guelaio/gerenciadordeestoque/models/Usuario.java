package br.com.guelaio.gerenciadordeestoque.models;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nome;

    @NotEmpty
    @Column(unique = true)
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private boolean admin;
    
    public Usuario() {
	
    }

    public Usuario(String nome, String username, String password, boolean admin) {
	setNome(nome);
	setUsername(username);
	setPassword(password);
	setAdmin(admin);
    }

    public Long getId() {
	return id;
    }

    public String getNome() {
	return nome;
    }

    private void setNome(String nome) {
	this.nome = nome;
    }

    public String getUsername() {
	return username;
    }

    private void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    private void setPassword(String password) {
	this.password = password;
    }

    public boolean isAdmin() {
	return admin;
    }

    private void setAdmin(boolean admin) {
	this.admin = admin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
	List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
	List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
	return isAdmin() ? authorityListAdmin : authorityListUser;
    }

    @Override
    public boolean isAccountNonExpired() {
	return true;
    }

    @Override
    public boolean isAccountNonLocked() {
	return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
	return true;
    }

    @Override
    public boolean isEnabled() {
	return true;
    }
}
