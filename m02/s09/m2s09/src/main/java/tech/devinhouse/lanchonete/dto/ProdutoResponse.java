package tech.devinhouse.lanchonete.dto;

import lombok.Data;

@Data
public class ProdutoResponse {

    private Integer codigo;

    private String categoria;

    private String descricao;

    private Float preco;

}
