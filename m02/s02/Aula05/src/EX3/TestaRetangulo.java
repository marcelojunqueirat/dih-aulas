package EX3;

import java.util.Scanner;

public class TestaRetangulo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um valor para o comprimento:");
        double comprimento = Double.parseDouble (sc.nextLine());

        System.out.println("Digite um valor para o largura:");
        double largura = Double.parseDouble (sc.nextLine());

        Retangulo retangulo = new Retangulo();
        retangulo.setComprimento(comprimento);
        retangulo.setLargura(largura);

        System.out.printf("Perimetro: %.2f.%n", retangulo.perimettro());
        System.out.printf("Area: %.2f.%n", retangulo.area());
    }
}
