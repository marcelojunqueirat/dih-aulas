package cadastropersonagens.ui;

import cadastropersonagens.model.Operacao;
import cadastropersonagens.model.Personagem;
import cadastropersonagens.util.ConversorOperacao;

import java.util.Scanner;

public class Ui {

    public void exibirMenu() {
        System.out.println("** Cadastro de Personagens **");
        System.out.println();
        System.out.println("-------- MENU --------");
        System.out.println();
        System.out.println("1 - Cadastrar Personagem");
        System.out.println("2 - Excluir Personagem");
        System.out.println("3 - Listar Personagens");
        System.out.println("4 - Exportar para arquivo");
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

    public Personagem obterDadosDoPersonagem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o nome do personagem: ");
        String personagemNome = scanner.nextLine();
        System.out.println("Informe a série do personagem: ");
        String personagemSerie = scanner.nextLine();
        System.out.println();
        Personagem personagem= new Personagem(personagemNome, personagemSerie);
        return personagem;
    }

    public void exibir(String mensagem) {
        System.out.println(mensagem);
        System.out.println();
    }

    public void exibir(Personagem personagem) {
        System.out.println(personagem);
    }

    public int obterIdDoPersonagem() {
        System.out.print("Informe o ID do personagem: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println();
        return id;
    }
}
