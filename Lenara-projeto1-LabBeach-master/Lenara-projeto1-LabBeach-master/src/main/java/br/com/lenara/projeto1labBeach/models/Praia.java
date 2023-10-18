package br.com.lenara.projeto1labBeach.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Data
@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table // tabela terá o mesmo nome da classe
public class Praia {
    // Não permitir cadastro duplicado
    //Não permitir cadastro com campos inválidos
    // todos serão preenchimento obrigatório
     //name.setError("Preenchimento obrigatório)}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true) // tornou unico o cadastro.Se na query colocar o mesmo ID, ele cadastra um novo objeto
    private Long id;
    @ManyToOne // "muitos para um" -- usar classe como atributo
    @JoinColumn(name = "bairro_id") //
    @NotNull
    private Bairro bairro;
    @NotBlank(message = " O preenchimento deste campo é obrigatório. ")

    @Column(nullable = false, unique = true) // não nulo. Ser unico (não permite preencher exatamente com a mesma informação)
    private String name;

    @NotNull(message = " O preenchimento deste campo é obrigatório. ")
    @Column(nullable = false)
     private Boolean acessibilidade;

    @NotBlank(message = " O preenchimento deste campo é obrigatório. ")
    @Column(nullable = false) // não nulo.
    private String status;


}
