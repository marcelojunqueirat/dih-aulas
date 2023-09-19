package aula01;

import java.util.Scanner;

public class EscolhaOpcao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mensagem = "Opção invalida. Informe apenas número. Tente novamente:";

        System.out.println("------ ESCOLHA O DEPTO QUE DESEJA ENTRAR EM CONTATO ------");
        System.out.println("-- 1 - Depto Comercial -----------------------------------");
        System.out.println("-- 2 - Depto Financeiro ----------------------------------");
        System.out.println("-- 3 - Depto RH ------------------------------------------");
        System.out.println("----------------------------------------------------------");

        int opcao = Integer.parseInt(sc.nextLine());
        if (opcao > 3 ){
            do {
                System.out.println(mensagem);
                opcao = Integer.parseInt(sc.nextLine());
            } while (opcao > 3);
        }

        switch (opcao) {
            case 1 -> mensagem = "Bem vindo ao Depto Comercial";
            case 2 -> mensagem = "Bem vindo ao Depto Financeiro";
            case 3 -> mensagem = "Bem vindo ao Depto RH";
        }
        System.out.println(mensagem);
    }
}
