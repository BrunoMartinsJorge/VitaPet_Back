package br.com.projeto_tcc.clinica_pet_vita.dto;

import br.com.projeto_tcc.clinica_pet_vita.enums.GeneroENUM;
import br.com.projeto_tcc.clinica_pet_vita.model.ClienteModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Base64;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome_cliente;
    private String cpf_cliente;
    private String telefone;
    private String email;
    private String rua;
    private String bairro;
    private String numero;
    private String complemento;
    private String cep;
    private GeneroENUM genero;
    private LocalDate data_nascimento;
    private int idade;
    private LocalDateTime data_hora_cadastro;
    private String foto_pessoa;

    public static ClienteDTO toDTO(ClienteModel cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome_cliente(cliente.getNome_cliente());
        dto.setCpf_cliente(cliente.getCpf_cliente());
        dto.setTelefone(cliente.getTelefone());
        dto.setEmail(cliente.getEmail());
        dto.setRua(cliente.getRua());
        dto.setBairro(cliente.getBairro());
        dto.setNumero(cliente.getNumero());
        dto.setComplemento(cliente.getComplemento());
        dto.setCep(cliente.getCep());
        dto.setGenero(cliente.getGenero_cliente());
        dto.setData_nascimento(cliente.getData_nascimento());
        dto.setIdade(Period.between(cliente.getData_nascimento(), LocalDate.now()).getYears());
        dto.setData_hora_cadastro(LocalDateTime.now());

        if (cliente.getFoto_pessoa() != null) {
            String base64 = Base64.getEncoder().encodeToString(cliente.getFoto_pessoa());
            dto.setFoto_pessoa("data:image/jpeg;base64," + base64);
        }

        return dto;
    }
}
