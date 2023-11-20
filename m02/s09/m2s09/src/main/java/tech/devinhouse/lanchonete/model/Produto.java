package tech.devinhouse.lanchonete.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUTOS")
public class Produto {

    @Id
    private Integer codigo;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(length = 200, nullable = false)
    private String descricao;

    private Float preco;


    public Produto(Integer codigo) {
        this.codigo = codigo;
    }


    @Override
    public String toString() {
        return String.format("Cod: %d - Categoria: %s - Desc: %s - Preço: R$ %.2f",
                codigo, categoria, descricao, preco);
    }

}
