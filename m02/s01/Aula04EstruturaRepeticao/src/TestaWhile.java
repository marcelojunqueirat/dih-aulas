import java.util.Scanner;

public class TestaWhile {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Insira um nome de usuario:");
        String nomeUsuario = entrada.nextLine();

        System.out.println("Insira uma senha:");
        String senhaUsuario = entrada.nextLine();

        while (nomeUsuario.equalsIgnoreCase(senhaUsuario)) {
            System.out.println("Nome de usuario e senha devem ser diferentes");
            System.out.println("Insira um nome de usuario:");
            nomeUsuario = entrada.nextLine();

            System.out.println("Insira uma senha:");
            senhaUsuario = entrada.nextLine();
        }

        System.out.printf("Usuario %s foi cadastrado com sucesso.", nomeUsuario);

    }
}