package tech.devinhouse.lanchonete.model;

public enum Operacao {

    LISTAR_PRODUTOS,
    LISTAR_CLIENTES,
    LISTAR_PEDIDOS,
    CADASTRAR_PEDIDO,
    SAIR;

    public static Operacao obterPorCodigo(int cod) {
        if (cod == 0 || cod > Operacao.values().length)
            throw new IllegalArgumentException("Código de Operacao inexistente!");
        return Operacao.values()[cod-1];
    }

}
