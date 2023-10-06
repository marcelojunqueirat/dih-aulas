package aula04.lomboklib;

import lombok.*;

//@Getter
//@Setter
//@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    private Long cpf;

    private String nome;

    private Integer idade;

}
