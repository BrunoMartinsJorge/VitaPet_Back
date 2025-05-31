package br.com.projeto_tcc.clinica_pet_vita.config.Security;

import br.com.projeto_tcc.clinica_pet_vita.config.TokenConfig.util.RoleENUM;
import br.com.projeto_tcc.clinica_pet_vita.model.UsuarioModel;
import br.com.projeto_tcc.clinica_pet_vita.repository.UsuarioRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(UsuarioModel usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(usuario.getEmail())
                    .withClaim("role", usuario.getRole().name())
                    .withExpiresAt(geradorDeDataDeExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro na hora da geração da token!", e);
        }
    }

    public String validarToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return "";
        }
    }

    private Instant geradorDeDataDeExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    @Service
    public static class AuthorizationService implements UserDetailsService {

        @Autowired
        private UsuarioRepository usuarioReporitory;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            return usuarioReporitory.findByEmail(username).get();
        }
    }

    public RoleENUM pegarRole(String token) {
        return JWT.decode(token).getClaim("role").as(RoleENUM.class);
    }
}
