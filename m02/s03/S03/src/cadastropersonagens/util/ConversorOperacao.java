package cadastropersonagens.util;

import cadastropersonagens.model.Operacao;

public class ConversorOperacao {
    public static Operacao converter(int opcao) {
        Operacao operacao = null;
        switch (opcao) {
            case 1:
                operacao = Operacao.CADASTRAR;
                break;
            case 2:
                operacao = Operacao.EXCLUIR;
                break;
            case 3:
                operacao = Operacao.LISTAR;
                break;
            case 4:
                operacao = Operacao.EXPORTAR;
                break;
            case 0:
                operacao = Operacao.SAIR;
                break;
            default:
                operacao = null;
        }
        return operacao;
    }

}
