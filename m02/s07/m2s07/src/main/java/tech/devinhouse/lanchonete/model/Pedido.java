package tech.devinhouse.lanchonete.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;

@Entity
@Table(name = "PEDIDOS")
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dataPedido;

    @ManyToOne
    @JoinColumn(name = "CPF_CLIENTE", referencedColumnName = "CPF")
    private Cliente cliente;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "pedido")
    private List<ItemPedido> itens;

    @Transient  // nao eh mapeado para nenhuma coluna do BD
    private Float valorTotal;


    public Pedido() {
        this.dataPedido = LocalDateTime.now();
    }


    public void adicionar(ItemPedido item) {
        if (this.itens == null)
            this.itens = new ArrayList<>();
        itens.add(item);
    }

    public void adicionar(Produto produto, int qtd) {
        if (itens == null)
            itens = new ArrayList<>();
        float valor = produto.getPreco() * qtd;
        var itemPedido = new ItemPedido(this, produto.getCodigo(), qtd, valor);
        itens.add(itemPedido);
    }


    public Float getValorTotal() {
        if (itens == null || itens.isEmpty())
            return 0F;
        Float total = 0F;
        for(ItemPedido item : this.itens) {
            total += item.getValor();
        }
//        Float total = this.itens.stream()
//                .map(item -> item.getValor())
//                .reduce(0F, Float::sum);
        return total;
    }

}
