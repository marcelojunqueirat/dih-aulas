package EX6;

import java.util.Scanner;

public class TestaPerfilDeSaude {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite seu peso em kg:");
        double peso = Double.parseDouble(sc.nextLine());

        System.out.println("Digite sua altura:");
        double altura = Double.parseDouble(sc.nextLine());

        PerfilDeSaude perfilDeSaude = new PerfilDeSaude(
                "Test",
                "Sobrenome",
                "Masculino",
                "Masculino",
                altura,
                peso
        );

        System.out.printf("Calculo do IMC: %.2f.%n", perfilDeSaude.imc());
    }
}
