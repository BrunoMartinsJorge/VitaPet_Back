package br.com.projeto_tcc.clinica_pet_vita.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EncriptadorSenha implements PasswordEncoder {

    @Override
    public String encode(CharSequence senha) {
        return BCrypt.withDefaults().hashToString(12, senha.toString().toCharArray());
    }

    @Override
    public boolean matches(CharSequence senha, String senhaEncriptada) {
        return BCrypt.verifyer().verify(senha.toString().toCharArray(), senhaEncriptada).verified;
    }
}