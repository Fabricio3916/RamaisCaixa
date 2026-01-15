package caixa.ramaiscaixa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ramal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "O número do ramal é obrigatório")
    @Positive(message = "O ramal deve ser um número positivo")
    private Integer ramal;

    @NotBlank(message = "O setor é obrigatório")
    private String setor;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;



}
