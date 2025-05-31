package br.com.projeto_tcc.clinica_pet_vita.model;

import br.com.projeto_tcc.clinica_pet_vita.enums.GeneroENUM;
import br.com.projeto_tcc.clinica_pet_vita.model.enums.TipoAnimalENUM;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "pets_clinica")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    @NotNull(message = "O nome não pode ser nulo!")
    private String nome;

    @Column(name = "data_nascimento")
    @NotNull(message = "A data de nascimento não pode ser nula!")
    private LocalDate data_nascimento;

    @Column(name = "data_cadastro")
    @NotNull(message = "A data de cadastro não pode ser nula!")
    @CreationTimestamp //Toda vez que uma entidade for criada já adicionara isso!
    private LocalDateTime data_cadastro;

    @Column(name = "id_dono")
    @NotNull(message = "O id do dono não pode ser nulo!")
    private Long idDono;

    @Column(name = "problemas_saude")
    @NotNull(message = "O problemas de saude não pode ser nulo!")
    private String problemas_saude;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero")
    @NotNull(message = "O genero não pode ser nulo!")
    private GeneroENUM genero;

    @Column(name = "castrado")
    @NotNull(message = "Esta castrado não pode ser nulo!")
    private boolean castrado;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    @NotNull(message = "O tipo do anil não pode ser nulo!")
    private TipoAnimalENUM tipo_animal;

    @Column(name = "raca")
    @NotNull(message = "A raça do animal não pode ser nula!")
    private String raca_animal;
}
