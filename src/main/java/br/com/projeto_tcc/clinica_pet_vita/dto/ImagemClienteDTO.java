package br.com.projeto_tcc.clinica_pet_vita.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImagemClienteDTO {

    private Long id;
    private MultipartFile imagem;
}
