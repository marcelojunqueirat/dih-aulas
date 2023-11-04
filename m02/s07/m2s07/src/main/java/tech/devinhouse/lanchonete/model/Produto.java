package tech.devinhouse.lanchonete.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUTOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    private Integer codigo;

    @Enumerated(EnumType.STRING)  // para gravar o nome da enum
    private Categoria categoria;

    private String descricao;

    private Float preco;

    @Override
    public String toString() {
        return String.format("Cod: %d - Categoria: %s - Desc: %s - Preço: R$ %.2f",
                codigo, categoria, descricao, preco);
    }

}
