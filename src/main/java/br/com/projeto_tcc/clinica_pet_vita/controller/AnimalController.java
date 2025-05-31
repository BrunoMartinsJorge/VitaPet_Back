package br.com.projeto_tcc.clinica_pet_vita.controller;

import br.com.projeto_tcc.clinica_pet_vita.dto.AnimalDTO;
import br.com.projeto_tcc.clinica_pet_vita.forms.AnimalCadastroForms;
import br.com.projeto_tcc.clinica_pet_vita.service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pets_clinica")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/listar-todos-pets")
    public ResponseEntity<List<AnimalDTO>> listarTodos() {
        return ResponseEntity.ok().body(animalService.listar_todos_pets());
    }

    @PostMapping("/cadastrar-animal")
    public ResponseEntity<AnimalDTO> cadastrar_novo_animal(@RequestBody @Valid AnimalCadastroForms animal) {
        return ResponseEntity.ok().body(animalService.cadastrar_pet(animal));
    }
}
