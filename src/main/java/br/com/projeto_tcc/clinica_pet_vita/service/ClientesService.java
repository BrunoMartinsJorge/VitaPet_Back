package br.com.projeto_tcc.clinica_pet_vita.service;

import br.com.projeto_tcc.clinica_pet_vita.dto.AnimalDTO;
import br.com.projeto_tcc.clinica_pet_vita.dto.ClienteDTO;
import br.com.projeto_tcc.clinica_pet_vita.dto.PetDeletado;
import br.com.projeto_tcc.clinica_pet_vita.exception.ClienteJaCadastradoException;
import br.com.projeto_tcc.clinica_pet_vita.exception.ExceptionHandler;
import br.com.projeto_tcc.clinica_pet_vita.forms.FormularioCadastroCliente;
import br.com.projeto_tcc.clinica_pet_vita.model.AnimalModel;
import br.com.projeto_tcc.clinica_pet_vita.model.ClienteModel;
import br.com.projeto_tcc.clinica_pet_vita.repository.AnimalRepository;
import br.com.projeto_tcc.clinica_pet_vita.repository.ClientesRepository;
import br.com.projeto_tcc.clinica_pet_vita.utils.EncriptadorSenha;
import jakarta.transaction.Transactional;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.validator.internal.constraintvalidators.hv.CodePointLengthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository repository_clientes;

    @Autowired
    private ModelMapper mapear;

    @Autowired
    private AnimalRepository animalRepository;

    public List<ClienteDTO> listarClientes() {
        List<ClienteModel> clientes = repository_clientes.findAll();
        return clientes.stream().map(ClienteDTO::toDTO).toList();
    }

    public Long adicionarCliente(FormularioCadastroCliente formulario) {
        ClienteModel cliente = mapear.map(formulario, ClienteModel.class);
        cliente.setData_hora_cadastro(LocalDateTime.now());
        if (repository_clientes.existsByEmail(formulario.getEmail())) {
            throw new ClienteJaCadastradoException("Um cliente com este email já foi cadastrado!");
        }
        repository_clientes.save(cliente);
        return repository_clientes.findByEmail(cliente.getEmail()).get().getId();
    }

    public ClienteDTO deletarCliente(Long id) {
        ClienteModel cliente = repository_clientes.findById(id).orElseThrow(() -> new RuntimeException("Cliete não encontrado com o ID: " + id));
        repository_clientes.deleteById(cliente.getId());
        return ClienteDTO.toDTO(cliente);
    }

    public List<AnimalDTO> buscarPetsCliente(Long idCliente) {
        List<AnimalModel> animais = animalRepository.findAllByIdDono(idCliente);
        return animais.stream().map(AnimalDTO::toDto).toList();
    }

    public PetDeletado excluirPet(Long idPet) {
        AnimalModel pet = animalRepository.findById(idPet).orElseThrow(() -> new RuntimeException("Pet com esse id não encontrado!"));
        PetDeletado dados = new PetDeletado();
        dados.setId(pet.getId());
        dados.setNomePet(pet.getNome());
        dados.setNomeDono(repository_clientes.findById(pet.getIdDono()).orElseThrow(() -> new RuntimeException("Cliente com esse id não encontrado!")).getNome_cliente());
        animalRepository.delete(pet);
        dados.setDataHoraExclusao(LocalDateTime.now());
        return dados;
    }

    @Transactional
    public void salvarImagem(MultipartFile file, Long id) throws IOException {

        ClienteModel cliente = this.repository_clientes.findById(id).orElseThrow();
        cliente.setFoto_pessoa(file.getBytes());
        repository_clientes.save(cliente);
    }
}
