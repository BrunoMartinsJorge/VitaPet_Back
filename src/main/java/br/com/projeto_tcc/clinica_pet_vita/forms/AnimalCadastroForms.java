package br.com.projeto_tcc.clinica_pet_vita.forms;

import br.com.projeto_tcc.clinica_pet_vita.enums.GeneroENUM;
import br.com.projeto_tcc.clinica_pet_vita.model.enums.TipoAnimalENUM;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalCadastroForms {

    private String nome;
    private LocalDate data_nascimento;
    private Long id_dono;
    private String problemas_saude;
    private GeneroENUM genero;
    private boolean castrado;
    private TipoAnimalENUM tipo_animal;
    private String raca_animal;
}
