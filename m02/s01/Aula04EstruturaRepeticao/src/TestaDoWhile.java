import java.util.Scanner;

public class TestaDoWhile {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        String nomeUsuario = "";
        String senhaUsuario= "" ;

        do {
            System.out.println("Nome de usuario e senha não podem ser iguais");
            System.out.println("Insira um nome de usuario:");
            nomeUsuario = entrada.nextLine();

            System.out.println("Insira uma senha:");
            senhaUsuario = entrada.nextLine();

        } while (nomeUsuario.equalsIgnoreCase(senhaUsuario));

        System.out.printf("Usuario %s foi cadastrado com sucesso.", nomeUsuario);
    }
}
