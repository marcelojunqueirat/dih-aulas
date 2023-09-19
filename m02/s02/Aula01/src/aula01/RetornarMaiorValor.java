package aula01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RetornarMaiorValor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> listaValores = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println("Informe o "+ (i+1) + "º valor para ordenar:");
            listaValores.add(Double.parseDouble(sc.nextLine()));
        }

        double maiorValor = 0;
        for (double valor : listaValores) {
            if(maiorValor < valor) {
                maiorValor = valor;
            }
        }

        System.out.println("Lista: " + listaValores);
        System.out.println("Maior valor é: " + maiorValor);

/*
        Collections.sort(listaValores);
        Collections.reverse(listaValores);
        System.out.println("O maior valor é: " + listaValores.get(0));
*/
    }
}
