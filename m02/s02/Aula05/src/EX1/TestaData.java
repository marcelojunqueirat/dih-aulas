package EX1;

import java.util.Scanner;

public class TestaData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um ano:");
        int ano = Integer.parseInt(sc.nextLine());

        System.out.println("Digite um mês:");
        int mes = Integer.parseInt(sc.nextLine());

        System.out.println("Digite um dia:");
        int dia = Integer.parseInt(sc.nextLine());

        Data novaData = new Data(dia, mes, ano);
        System.out.println(novaData.exibirData());
    }
}
