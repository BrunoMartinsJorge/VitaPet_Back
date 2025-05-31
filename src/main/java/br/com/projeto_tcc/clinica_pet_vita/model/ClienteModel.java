package br.com.projeto_tcc.clinica_pet_vita.model;

import br.com.projeto_tcc.clinica_pet_vita.enums.GeneroENUM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cliente_clinica")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome_cliente;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate data_nascimento;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "cpf")
    private String cpf_cliente;

    @Column(name = "genero")
    @Enumerated(EnumType.STRING)
    private GeneroENUM genero_cliente;

    @Column(name = "cep")
    private String cep;

    @Column(name = "rua")
    private String rua;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "numero")
    private String numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "data_hora_cadastro")
    private LocalDateTime data_hora_cadastro;

    @Column(name = "email")
    private String email;

    @Lob
    @Column(name = "foto_pessoa", columnDefinition = "MEDIUMBLOB")
    private byte[] foto_pessoa;
}
