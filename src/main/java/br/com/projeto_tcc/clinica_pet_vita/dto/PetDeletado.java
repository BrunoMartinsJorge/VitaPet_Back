package br.com.projeto_tcc.clinica_pet_vita.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDeletado {
    private Long id;
    private String nomePet;
    private String nomeDono;
    private LocalDateTime dataHoraExclusao;
}
