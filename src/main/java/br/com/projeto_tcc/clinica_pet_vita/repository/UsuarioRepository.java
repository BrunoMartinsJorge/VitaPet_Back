package br.com.projeto_tcc.clinica_pet_vita.repository;

import br.com.projeto_tcc.clinica_pet_vita.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    Optional<UsuarioModel> findByEmail(String email);
}
