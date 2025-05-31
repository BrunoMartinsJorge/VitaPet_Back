package br.com.projeto_tcc.clinica_pet_vita.controller;

import br.com.projeto_tcc.clinica_pet_vita.forms.FormularioLogin;
import br.com.projeto_tcc.clinica_pet_vita.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> logarUsuario(@RequestBody @Valid FormularioLogin login) {
        return ResponseEntity.ok().body(Map.of("token", loginService.logarUsuario(login)));
    }
}
