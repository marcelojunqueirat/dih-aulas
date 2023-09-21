package objetos;

public class TestaTransferencia {
    public static void main(String[] args) {
        Conta c1 = new Conta();
        Conta c2 = new Conta();

        c1.titular = new Cliente();
        c1.titular.nome = "Jonas";
        c1.depositar(200);

        c2.titular = new Cliente();
        c2.titular.nome = "Maria";
        c1.transferir(c2, 50);

        System.out.printf("Saldo da c1 é R$%.2f.%n", c1.getSaldo());
        System.out.printf("Saldo da c2 é R$%.2f.%n", c2.getSaldo());
    }
}
