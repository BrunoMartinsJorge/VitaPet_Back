package br.com.projeto_tcc.clinica_pet_vita.controller;

import br.com.projeto_tcc.clinica_pet_vita.dto.AnimalDTO;
import br.com.projeto_tcc.clinica_pet_vita.dto.ClienteDTO;
import br.com.projeto_tcc.clinica_pet_vita.dto.PetDeletado;
import br.com.projeto_tcc.clinica_pet_vita.forms.FormularioCadastroCliente;
import br.com.projeto_tcc.clinica_pet_vita.model.ClienteModel;
import br.com.projeto_tcc.clinica_pet_vita.repository.ClientesRepository;
import br.com.projeto_tcc.clinica_pet_vita.service.ClientesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriBuilder;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @GetMapping
    public List<ClienteDTO> listar() {
        return clientesService.listarClientes();
    }

    @PostMapping
    public ResponseEntity<Long> cadastrar(@RequestBody @Valid FormularioCadastroCliente formulario) {
        return ResponseEntity.ok().body(clientesService.adicionarCliente(formulario));
    }

    @PostMapping("upload/{id}/imagem")
    public ResponseEntity<String> uploadImagem(@PathVariable Long id, @RequestParam("image") MultipartFile image) {
        try {
            clientesService.salvarImagem(image, id);
            return ResponseEntity.ok().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar a imagem.");
        }
    }

    @GetMapping("/buscar-pets-cliente/{idDono}")
    public ResponseEntity<List<AnimalDTO>> buscarPetsDeCliente(@PathVariable Long idDono){
        return ResponseEntity.ok().body(clientesService.buscarPetsCliente(idDono));
    }

    @DeleteMapping("/deletar-cliente/{id}")
    public ResponseEntity<ClienteDTO> deletarCliente(@PathVariable Long id){
        return ResponseEntity.ok().body(clientesService.deletarCliente(id));
    }

    @DeleteMapping("/excluir-pet/{idPet}")
    public ResponseEntity<PetDeletado> excluirPet(@PathVariable Long idPet) {
        return ResponseEntity.ok().body(clientesService.excluirPet(idPet));
    }
}
