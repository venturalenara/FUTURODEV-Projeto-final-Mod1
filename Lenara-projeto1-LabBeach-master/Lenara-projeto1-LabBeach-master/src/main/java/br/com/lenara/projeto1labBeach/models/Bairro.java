package br.com.lenara.projeto1labBeach.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

// anotations
@Data
@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table // nome tabela será o mesmo da classe
public class Bairro {
    // Não permitir cadastro duplicado
    //Não permitir cadastro com campos inválidos
    // colunas na tabela bairros,  no BD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // usado o identity, pois se aquele ID for removido, não pode ser mais usado
    @Column(unique = true) // torna unica para o cadastro. se na query colocar o mesmo ID ele cadastra um novo objeto
    private Long id; // Id: Único, autogerado.
    @NotBlank(message = " O preenchimento deste campo é obrigatório ") // nao deixa o campo string ser preenchido vazio
    @Column(nullable = false, unique = true) // não nulo. Ser unico (não permite preencher exatamente com a mesma informação)
    private String name; // Único, tipo texto, preenchimento obrigatório
    private String description; //  Tipo texto, preenchimento não obrigatório. No DB tem que configurar  NULL? No DB configurar limitador de caracter?
    private Integer population; // Tipo inteiro, preenchimento não obrigatório. No DB tem que configurar  NULL?



}
