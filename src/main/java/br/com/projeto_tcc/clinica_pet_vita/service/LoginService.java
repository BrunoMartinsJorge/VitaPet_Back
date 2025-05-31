package br.com.projeto_tcc.clinica_pet_vita.service;

import br.com.projeto_tcc.clinica_pet_vita.config.Security.TokenService;
import br.com.projeto_tcc.clinica_pet_vita.forms.FormularioLogin;
import br.com.projeto_tcc.clinica_pet_vita.model.UsuarioModel;
import br.com.projeto_tcc.clinica_pet_vita.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public String logarUsuario(FormularioLogin formularioLogin) {
        var usernamePassowrd = new UsernamePasswordAuthenticationToken(formularioLogin.getEmail(), formularioLogin.getSenha());
        var auth = this.authenticationManager.authenticate(usernamePassowrd);
        return tokenService.gerarToken((UsuarioModel) auth.getPrincipal());
    }
}
