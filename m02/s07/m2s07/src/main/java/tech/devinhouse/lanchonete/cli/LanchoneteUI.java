package tech.devinhouse.lanchonete.cli;

import org.springframework.stereotype.Component;
import tech.devinhouse.lanchonete.model.Operacao;
import tech.devinhouse.lanchonete.model.Produto;

import java.util.List;
import java.util.Scanner;

import static tech.devinhouse.lanchonete.cli.ConsoleColors.*;

@Component
public class LanchoneteUI {

    public void mostrarMenu() {
        System.out.println();
        System.out.println(BLUE_BOLD + "*** MENU ***" + RESET);
        System.out.println(BLUE + "1 - Listar Produtos" + RESET);
        System.out.println(BLUE + "2 - Listar Clientes" + RESET);
        System.out.println(BLUE + "3 - Listar Pedidos" + RESET);
        System.out.println(BLUE + "4 - Cadastrar Pedido" + RESET);
        System.out.println(BLUE + "5 - Sair" + RESET);
        System.out.println();
    }

    public void esperar() {
        System.out.println();
        System.out.println(YELLOW_BOLD + "Digite qualquer tecla para continuar..." + RESET);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println();
    }

    public Operacao obterOperacao() {
        System.out.print("Informe o código da operacao: ");
        Scanner scanner = new Scanner(System.in);
        int cod = scanner.nextInt();
        Operacao operacao = Operacao.obterPorCodigo(cod);
        return operacao;
    }

    public void exibirMensagemErro(String mensagem) {
        System.out.println();
        System.out.println(RED + mensagem + RESET);
        esperar();
    }

    public void exibirMensagemInfo(String mensagem) {
        System.out.println();
        System.out.println(BLUE + mensagem + RESET);
        esperar();
    }

    public void exibirMensagemSucesso(String mensagem) {
        System.out.println();
        System.out.println(GREEN + mensagem + RESET);
        esperar();
    }

    public <T> void listar(List<T> lista) {
        System.out.println();
        System.out.println(BLUE_BOLD + "Listando..." + RESET);
        System.out.println();
        lista.forEach(System.out::println);
        esperar();
    }

    public Long obterCpfCliente() {
        System.out.print("Informe o CPF do cliente: ");
        Scanner scanner = new Scanner(System.in);
        long cpf = scanner.nextLong();
        return cpf;
    }

    public Integer obterProdutoDoPedido() {
        System.out.print("Informe o código do produto: ");
        Scanner scanner = new Scanner(System.in);
        int cod = scanner.nextInt();
        return cod;
    }

    public Integer obterQuantidadeDoProduto(Produto produto) {
        System.out.print(String.format("Informe a quantidade do produto: %d = %s : ",
                produto.getCodigo(), produto.getDescricao()));
        Scanner scanner = new Scanner(System.in);
        int qtd = scanner.nextInt();
        return qtd;
    }

    public boolean verificarNovoItem() {
        System.out.print("Deseja adicionar mais um item no pedido? [S/N] ");
        Scanner scanner = new Scanner(System.in);
        String resp = scanner.next();
        return resp.toUpperCase().equals("S");
    }

}
