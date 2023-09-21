package objetos;

public class TesteAtributos {
    public static void main(String[] args) {
        Conta contaTeste = new Conta();

        System.out.println(contaTeste);

        Cliente cli = new Cliente();
        cli.nome = "Juniper";
        cli.sobrenome = "Wok";
        cli.cpf = "12345678911";
        contaTeste.titular = cli;

        System.out.println(contaTeste);

    }
}
