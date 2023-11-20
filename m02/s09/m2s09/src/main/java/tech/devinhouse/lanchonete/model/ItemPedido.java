package tech.devinhouse.lanchonete.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ITENS_PEDIDOS")
@IdClass(IdItemPedido.class)
public class ItemPedido {

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_PEDIDO", referencedColumnName = "ID")
    private Pedido pedido;

    @Id
    @Column(name = "COD_PRODUTO", nullable = false)
    private Integer codigoProduto;

    private int quantidade;

    @Column(name = "VL_ITEM")
    private float valor;


    @Override
    public String toString() {
        return "ItemPedido{" +
                "codigoProduto=" + codigoProduto +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                '}';
    }

}
