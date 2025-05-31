package br.com.projeto_tcc.clinica_pet_vita.service;

import br.com.projeto_tcc.clinica_pet_vita.dto.AnimalDTO;
import br.com.projeto_tcc.clinica_pet_vita.forms.AnimalCadastroForms;
import br.com.projeto_tcc.clinica_pet_vita.model.AnimalModel;
import br.com.projeto_tcc.clinica_pet_vita.repository.AnimalRepository;
import br.com.projeto_tcc.clinica_pet_vita.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animal_repository;

    @Autowired
    private ClientesRepository cliente_repository;

    public List<AnimalDTO> listar_todos_pets(){
        List<AnimalModel> lista = animal_repository.findAll();
        List<AnimalDTO> lista_animals = new ArrayList<>();
        lista_animals.addAll(lista.stream().map(AnimalDTO::toDto).toList());
        return lista_animals;
    }

    public AnimalDTO cadastrar_pet(AnimalCadastroForms forms) {
        try {
            cliente_repository.findById(forms.getId_dono()).get();
        } catch (Exception e) {
            throw new RuntimeException("Não foi encontrado um clinete com este id!");
        }
        AnimalModel animal = new AnimalModel();
        animal.setNome(forms.getNome());
        animal.setIdDono(forms.getId_dono());
        animal.setProblemas_saude(forms.getProblemas_saude());
        animal.setGenero(forms.getGenero());
        animal.setData_nascimento(forms.getData_nascimento());
        animal.setData_cadastro(LocalDateTime.now());
        animal.setRaca_animal(forms.getRaca_animal());
        animal.setTipo_animal(forms.getTipo_animal());
        animal.setCastrado(forms.isCastrado());
        animal_repository.save(animal);
        AnimalDTO animalDTO = new AnimalDTO();
        return animalDTO.toDto(animal);
    }
}
