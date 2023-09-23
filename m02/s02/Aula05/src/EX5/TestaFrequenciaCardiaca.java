package EX5;

import java.util.Scanner;

public class TestaFrequenciaCardiaca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite sua data de nascimento:");
        String dataNascimento = sc.nextLine();

        FrequenciaCardiaca frequenciaCardiaca = new FrequenciaCardiaca("Fulano", "Blabla", dataNascimento);

        System.out.printf(
                "Idade: %d %n Freq. Card. Max.: %d %n Freq. Card. Alvo: %.1f - %.1f",
                frequenciaCardiaca.calculaIdade(),
                frequenciaCardiaca.frequenciaCardiacaMaxima(),
                frequenciaCardiaca.frequenciaCardiacaAlvo()[0],
                frequenciaCardiaca.frequenciaCardiacaAlvo()[1]
        );

    }
}
