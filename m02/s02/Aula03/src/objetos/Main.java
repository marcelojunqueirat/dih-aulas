package objetos;

public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = a;
        System.out.println(a);
        System.out.println(b);
        b = 20;
        System.out.println(a);
        System.out.println(b);

        Cliente titular1 = new Cliente();
        Conta c1 = new Conta(titular1);
        c1.depositar(100);

        System.out.printf("Saldo de c1 é R$%.2f %n", c1.getSaldo());

        Conta c2 = c1;
        c2.depositar(200);
        System.out.printf("Saldo de c1 é R$%.2f %n", c1.getSaldo());
        System.out.printf("Saldo de c2 é R$%.2f %n", c2.getSaldo());
        System.out.println(c1);
        System.out.println(c2);

        if(c1 == c2) {
            System.out.println("São o mesmo objeto");
        }

    }
}
