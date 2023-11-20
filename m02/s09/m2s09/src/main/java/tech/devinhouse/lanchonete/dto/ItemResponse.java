package tech.devinhouse.lanchonete.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponse {

    private Integer codigoProduto;

    private Integer quantidade;

    private Float valorItem;

}
