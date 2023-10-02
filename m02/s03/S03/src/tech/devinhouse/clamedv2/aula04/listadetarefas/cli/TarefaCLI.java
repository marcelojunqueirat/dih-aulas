package tech.devinhouse.clamedv2.aula04.listadetarefas.cli;

import tech.devinhouse.clamedv2.aula04.listadetarefas.util.ConversorOperacao;
import tech.devinhouse.clamedv2.aula04.listadetarefas.model.Operacao;
import tech.devinhouse.clamedv2.aula04.listadetarefas.model.Tarefa;

import java.util.Scanner;

/**
 * Classe responsável por interações com o usuário.
 */
public class TarefaCLI {

    public void exibirMenu() {
        System.out.println("** Lista de Tarefas **");
        System.out.println();
        System.out.println("-------- MENU --------");
        System.out.println();
        System.out.println("1 - Adicionar Tarefa");
        System.out.println("2 - Excluir Tarefa");
        System.out.println("3 - Consultar Tarefas");
        System.out.println("4 - Consultar Tarefas por id");
        System.out.println("5 - Marcar tarefa como concluída");
        System.out.println("6 - Exportar para arquivo");
        System.out.println("0 - Sair");
        System.out.println();
    }

    public Operacao obterOperacao() {
        System.out.print("Informe a operacao desejada: ");
        Scanner scanner = new Scanner(System.in);
        int op = scanner.nextInt();
        Operacao operacao = ConversorOperacao.converter(op);
        return operacao;
    }

    public void finalizar() {
        System.out.println();
        System.out.println("Programa encerrado!");
    }

    public void exibirMensagemErro(String msg) {
        System.out.println();
        System.out.println(msg);
        System.out.println();
    }

    public void aguardar() {
        System.out.println("Pressione qualquer tecla para continuar... ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println();
    }

    public Tarefa obterDadosDaTarefa() {
        System.out.println("Informe o texto da tarefa: ");
        Scanner scanner = new Scanner(System.in);
        String texto = scanner.nextLine();
        System.out.println();
        Tarefa tarefa = new Tarefa(texto);
        return tarefa;
    }

    public void exibir(String mensagem) {
        System.out.println(mensagem);
        System.out.println();
    }

    public void exibir(Tarefa tarefa) {
        System.out.println(tarefa);
    }

    public int obterIdDaTarefa() {
        System.out.print("Informe o ID da tarefa: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println();
        return id;
    }

}
