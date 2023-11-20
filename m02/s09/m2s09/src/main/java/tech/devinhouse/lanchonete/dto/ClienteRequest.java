package tech.devinhouse.lanchonete.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClienteRequest {

    @NotNull(message = "Campo obrigatório")
    private Long cpf;

    @NotEmpty(message = "Campo obrigatório")
    private String nome;

}
