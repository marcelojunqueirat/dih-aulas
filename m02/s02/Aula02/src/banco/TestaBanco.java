package banco;

import java.util.Scanner;

public class TestaBanco {
    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.nomeTitular = "Marcelo";
        conta.depositar(100);
        conta.sacar(50);

        System.out.printf("A conta do cliente %s possui R$%.2f de saldo. %n", conta.getNomeTitular(), conta.getSaldo());

        Conta outraConta = new Conta();
        Scanner sc = new Scanner(System.in);

        System.out.println("\nInsira um nome para o titular:");
        outraConta.nomeTitular = sc.nextLine();

        System.out.println("Informe um valor de deposito inicial:");
        double valorDepositoInicial = Double.parseDouble(sc.nextLine());
        outraConta.depositar(valorDepositoInicial);

        System.out.println("Você deseja consultar o saldo da sua conta? Y/n");
        String decisao = sc.nextLine();

        if("Y".equalsIgnoreCase(decisao)){
            System.out.printf("Saldo da sua conta é: R$%.2f", outraConta.getSaldo());
        }


    }
}
