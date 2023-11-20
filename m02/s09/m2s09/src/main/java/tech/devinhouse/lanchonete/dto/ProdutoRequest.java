package tech.devinhouse.lanchonete.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProdutoRequest {

    @NotNull(message = "Campo Obrigatório")
    private Integer codigo;

    @NotEmpty(message = "Campo Obrigatório")
    private String categoria;

    @NotEmpty(message = "Campo Obrigatório")
    @Size(min = 1, max = 200, message = "Campo inválido")
    private String descricao;

    @NotNull(message = "Campo Obrigatório")
    private Float preco;

}
