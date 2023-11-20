package tech.devinhouse.lanchonete.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class PedidoRequest {

    @NotNull(message = "Campo obrigatório")
    private Long cpf;

    @NotEmpty(message = "Campo obrigatório")
    private List<ItemRequest> itens;

}
