package tech.devinhouse.lanchonete.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AutenticacaoRequest {

    @NotEmpty(message = "Campo obrigatório")
    @Email(message = "Campo Inválido")
    private String email;

    @NotEmpty(message = "Campo obrigatório")
    private String senha;

}
