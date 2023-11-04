package tech.devinhouse.lanchonete.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity   // indica que é uma entidade JPA e pode ser persistida no BD
@Table(name = "CLIENTES")  // indica o nome da tabela que será usado
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id  // indica que é chave primária
    private Long cpf;

    private String nome;

}
