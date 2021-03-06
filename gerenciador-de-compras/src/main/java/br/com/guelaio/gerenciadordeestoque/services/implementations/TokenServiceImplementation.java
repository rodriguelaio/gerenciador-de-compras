package br.com.guelaio.gerenciadordeestoque.services.implementations;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.guelaio.gerenciadordeestoque.models.Usuario;
import br.com.guelaio.gerenciadordeestoque.services.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenServiceImplementation implements TokenService {

    @Value("${forum.jwt.expiration}")
    private String expiration;

    @Value("${forum.jwt.secret}")
    private String secret; //SENHA DA APLICACAO QUE SER� UTILIZADA PARA GERAR O HASH - RECOMENDADO SER  UM STRING ALEAT�RIA COM MUITOS CARACTERES


    public String gerarToken(Authentication authentication) {
        Usuario logado = (Usuario) authentication.getPrincipal();
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
        //setIssuer - QUEM EST� GERANDO ESSE TOKEN
        //setSubject - STRING QUE IDENTIFIQUE UNICAMENTE MEU USU�RIO
        //signWith - Settar a senha e o algoritmo utilizado
        return Jwts.builder()
                .setSubject(logado.getId().toString())
                .setIssuedAt(hoje)
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean isTokenValido(String token) {
        //DESCRIPTOGRAFA E VERIFICA SE EST� OK
        try{
            //TEM QUE SER O QUE RETORNA Jws<Claims>
            //SE ELE NAO CONSEGUIR FAZER O PARSE ELE IR� LANCAR UMA EXCEPTION
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch(Exception e){
            return false;
        }

    }

    public Long getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        //PEGA O ID
        return Long.parseLong(claims.getSubject());
    }
}
