package br.com.projeto_tcc.clinica_pet_vita.dto;

import br.com.projeto_tcc.clinica_pet_vita.enums.GeneroENUM;
import br.com.projeto_tcc.clinica_pet_vita.model.AnimalModel;
import br.com.projeto_tcc.clinica_pet_vita.model.enums.TipoAnimalENUM;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalDTO {

    private Long id;
    private String nome;
    private int idade;
    private LocalDateTime data_cadastro;
    private Long id_dono;
    private String problemas_saude;
    private GeneroENUM genero;
    private boolean castrado;
    private TipoAnimalENUM tipo_animal;
    private String raca_animal;

    public static AnimalDTO toDto(AnimalModel dados) {
        AnimalDTO dto = new AnimalDTO();
        dto.setId(dados.getId());
        dto.setNome(dados.getNome());
        dto.setIdade(Period.between(dados.getData_nascimento(), LocalDate.now()).getYears());
        dto.setData_cadastro(dados.getData_cadastro());
        dto.setId_dono(dados.getIdDono());
        dto.setProblemas_saude(dados.getProblemas_saude());
        dto.setGenero(dados.getGenero());
        dto.setCastrado(dados.isCastrado());
        dto.setTipo_animal(dados.getTipo_animal());
        dto.setRaca_animal(dados.getRaca_animal());
        return dto;
    }
}
