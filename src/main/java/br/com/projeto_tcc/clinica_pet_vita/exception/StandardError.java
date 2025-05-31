package br.com.projeto_tcc.clinica_pet_vita.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class StandardError {

    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String path;
}
