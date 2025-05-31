package br.com.projeto_tcc.clinica_pet_vita.repository;

import br.com.projeto_tcc.clinica_pet_vita.model.AnimalModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<AnimalModel, Long> {

    List<AnimalModel> findAllByIdDono(long idDono);
}
