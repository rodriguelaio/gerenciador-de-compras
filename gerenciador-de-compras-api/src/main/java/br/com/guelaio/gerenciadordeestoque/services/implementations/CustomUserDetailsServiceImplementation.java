package br.com.guelaio.gerenciadordeestoque.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import br.com.guelaio.gerenciadordeestoque.repositories.UsuarioRepository;

@Service
public class CustomUserDetailsServiceImplementation implements UserDetailsService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
//        return usuarioRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Dados inv�lidos"));
	return usuarioRepository.findByUsername(username).get();
    }
}
