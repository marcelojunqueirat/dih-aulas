package tech.devinhouse.lanchonete.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ITENS_PEDIDOS")
@IdClass(IdItemPedido.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_PEDIDO", referencedColumnName = "ID")
    private Pedido pedido;

    @Id
    @Column(name = "COD_PRODUTO")
    private Integer codigoProduto;

    private int quantidade;

    @Column(name = "VL_ITEM")
    private float valor;   // quantidade * preco


    @Override
    public String toString() {
        return "ItemPedido{" +
                "codigoProduto=" + codigoProduto +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                '}';
    }

}
