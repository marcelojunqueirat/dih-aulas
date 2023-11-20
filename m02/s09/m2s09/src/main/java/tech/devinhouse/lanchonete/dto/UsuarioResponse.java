package tech.devinhouse.lanchonete.dto;

import lombok.Data;

@Data
public class UsuarioResponse {

    private Integer id;

    private String nome;

    private String email;

    private String role;

}
