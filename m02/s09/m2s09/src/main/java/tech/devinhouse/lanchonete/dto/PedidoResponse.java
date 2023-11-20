package tech.devinhouse.lanchonete.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.devinhouse.lanchonete.model.ItemPedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResponse {

    private Integer id;

    private LocalDateTime data;

    private Long cpf;

    private List<ItemResponse> itens;

    private Float valotTotal;


    public PedidoResponse(Integer id, LocalDateTime data, Long cpf, Float valotTotal, List<ItemPedido> itensPedido) {
        this.id = id;
        this.data = data;
        this.cpf = cpf;
        this.valotTotal = valotTotal;
        this.itens = new ArrayList<>();
        for (ItemPedido itemPedido : itensPedido) {
            var item = new ItemResponse(itemPedido.getCodigoProduto(), itemPedido.getQuantidade(), itemPedido.getValor());
            this.itens.add(item);
        }
    }

}
