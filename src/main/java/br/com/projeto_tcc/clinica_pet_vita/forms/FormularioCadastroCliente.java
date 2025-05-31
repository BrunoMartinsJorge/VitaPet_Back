package br.com.projeto_tcc.clinica_pet_vita.forms;

import br.com.projeto_tcc.clinica_pet_vita.enums.GeneroENUM;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormularioCadastroCliente {

    @NotNull(message = "O nome é obrigatório!")
    private String nome_cliente;

    @NotNull(message = "O cpf é obrigatório!")
    private String cpf_cliente;

    @NotNull(message = "O telefone é obrigatório!")
    private String telefone;

    @NotNull(message = "O email é obrigatório!")
    private String email;

    @NotNull(message = "A data de nascimento é obrigatória")
    @Past(message = "A data de nascimento deve estar no passado")
    private LocalDate data_nascimento;

    @NotNull(message = "O genero é obrigatório!")
    private GeneroENUM genero_cliente;

    @NotNull(message = "O cep é obrigatório!")
    private String cep;

    @NotNull(message = "O bairro é obrigatório!")
    private String bairro;

    @NotNull(message = "A rua é obrigatório!")
    private String rua;

    @NotNull(message = "O número é obrigatório!")
    private String numero;

    private String complemento;
}
