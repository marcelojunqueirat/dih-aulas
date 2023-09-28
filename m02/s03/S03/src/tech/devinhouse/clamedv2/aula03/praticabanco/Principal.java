package tech.devinhouse.clamedv2.aula03.praticabanco;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

//        Instanciar novo Cliente;
        Cliente cliente = new Cliente();
//        Indicar no cliente criado os dados: “John Snow”, 25 anos, vigilante;
        cliente.setNome("John Snow");
        cliente.setIdade(25);
        cliente.setProfissao("Vigilante");

//        Criar objeto de Conta Bancária e setar os dados: “Banco Bamerindus”, Agência 123,
//        Conta 987, saldo de R$ 1000.00, do cliente instanciado acima,
//        e data de criação em 30/07/2022 as 10 horas;
        ContaBancaria conta = new ContaBancaria();
        conta.setNomeBanco("Bamerindus");
        conta.setAgencia(123);
        conta.setConta(987);
        conta.setSaldo(1000);
        conta.setCliente(cliente);
        conta.setDataCriacao(LocalDateTime.of(2023, Month.JULY, 30, 10, 0, 0));

//        Imprimir no console o nome do cliente em maiúsculo e também os dados do cliente;
        System.out.println(cliente.obterNomeEmMaiusculo());
        System.out.println(cliente.obterDadosFormatados());
        System.out.println(cliente);

//        Solicitar via linha de comando o valor do saque;
        System.out.print("Informe o valor do saque: ");
        Scanner scanner = new Scanner(System.in);
        double valor = scanner.nextDouble();

//        Utilizar o método de sacar() da classe Conta para subtrair do saldo o valor do saque informado
//        e imprimir no console a frase: “Saque realizado! Saldo atual = <valor do saldo atualizado>”
        conta.sacar(valor);
        System.out.println("Saque realizado! Saldo atual = " + conta.getSaldo());

    }

}
