package aula04.bibliotecas;

import org.apache.commons.lang3.StringUtils;

public class Main {

    public static void main(String[] args) {

        String sapatoComZerosAEsquerda =
                StringUtils.leftPad("sapato", 20, "0");
        System.out.println(sapatoComZerosAEsquerda);

    }

}
