package tech.devinhouse.lanchonete.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@Entity
@Table(name = "PEDIDOS")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dataPedido;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CPF_CLIENTE", referencedColumnName = "CPF")
    private Cliente cliente;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "pedido")
    private List<ItemPedido> itens;

    @Transient // (nao gravado) valor calculado = Somatorio dos valores (parciais) de cada item de pedido
    private Float valorTotal;


    public Pedido() {
        this.dataPedido = LocalDateTime.now();
    }

    public Pedido(Cliente cliente) {
        this();
        this.cliente = cliente;
    }


    public void adicionar(Produto produto, int qtd) {
        if (itens == null)
            itens = new ArrayList<>();
        float valor = produto.getPreco() * qtd;
        var itemPedido = new ItemPedido(this, produto.getCodigo(), qtd, valor);
        itens.add(itemPedido);
    }

    public void adicionar(Integer codigoProduto, int qtd) {
        if (itens == null)
            itens = new ArrayList<>();
        var itemPedido = new ItemPedido(this, codigoProduto, qtd, 0F);
        itens.add(itemPedido);
    }


    @Override
    public String toString() {
        String resultado = String.format("Pedido nro %d em %s - Cliente CPF %d - %s - Valor total =  R$ %.2f",
                    id, dataPedido, cliente.getCpf(), cliente.getNome(), this.getValorTotal());
        resultado += "\n\r";
        resultado += "\t Itens do pedido: \n\r";
        for (ItemPedido item : itens) {
            resultado += "\t\t - " + item + "\n\r";
        }
        return resultado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public Float getValorTotal() {
        if (itens == null) return 0F;
        Float total = itens.stream().map(ItemPedido::getValor).reduce(0F, Float::sum);
        return total;
    }

}
