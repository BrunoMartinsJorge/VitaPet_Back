package br.com.projeto_tcc.clinica_pet_vita.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormularioLogin {

    private String email;
    private String senha;
}
