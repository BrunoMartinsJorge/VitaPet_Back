package br.com.projeto_tcc.clinica_pet_vita.repository;

import br.com.projeto_tcc.clinica_pet_vita.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientesRepository extends JpaRepository<ClienteModel, Long> {
    Boolean existsByEmail(String email);
    Optional<ClienteModel> findByEmail(String email);
}
