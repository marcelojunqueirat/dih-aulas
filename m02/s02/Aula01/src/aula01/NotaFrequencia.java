package aula01;

import java.util.ArrayList;
import java.util.Scanner;

public class NotaFrequencia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double media = 0.0;
        double frequencia = 0.0;
        String situacao = "Reprovado";
        int numeroDeAulas = 20;

        ArrayList<Double> notas = new ArrayList<>();

        System.out.println("Informe o número de faltas: ");
        int numeroFaltas = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < 3; i++) {
            System.out.println("Informe a "+ (i+1) + "ª nota:");
            notas.add(Double.parseDouble(sc.nextLine()));
        }

        for (double nota : notas) {
            media += nota;
        }

        frequencia = 100 - ((double) (numeroFaltas * 100) / numeroDeAulas);
        media = media / notas.size();

        if (media >= 7.0 && frequencia > 75.0){
            situacao = "Aprovado";
        }

        System.out.printf("Sua média é de: %.2f. Sua frequência é %.2f%%. Você está %s.%n", media, frequencia, situacao);


    }
}
