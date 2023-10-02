package tech.devinhouse.clamedv2.aula04.listadetarefas.util;

import tech.devinhouse.clamedv2.aula04.listadetarefas.model.Operacao;

/**
 * Classe responsável por converter um codigo de operacao informado pelo usuario
 * na respectiva Operacao.
 */
public class ConversorOperacao {

    public static Operacao converter(int opcao) {
        Operacao operacao = null;
        switch (opcao) {
            case 1:
                operacao = Operacao.ADICIONAR;
                break;
            case 2:
                operacao = Operacao.EXCLUIR;
                break;
            case 3:
                operacao = Operacao.LISTAR;
                break;
            case 4:
                operacao = Operacao.LISTAR_POR_ID;
                break;
            case 5:
                operacao = Operacao.MARCAR_CONCLUIDO;
                break;
            case 6:
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
