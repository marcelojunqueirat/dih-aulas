package exercicios.exercicio04;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean isIdadeValida = false;

        while (!isIdadeValida) {
            System.out.println("Informe sua idade");
            Scanner scanner = new Scanner(System.in);
            int idade = scanner.nextInt();
            try {
                validarIdade(idade);  // aqui for lancado a excecao, vai quebrar direto pro catch
                System.out.println("Olá, você tem " + idade +" anos de idade!");
                isIdadeValida = true;
            } catch (IdadeInvalidaException e) {
                System.out.println("Vc informou uma idade invalida");
                isIdadeValida = false;
            }
        }

    }

    private static void validarIdade(int idade) {
        if (idade <= 0 || idade > 100 ) {
//            throw new IllegalArgumentException("Idade invalida");
            throw new IdadeInvalidaException();  // vai lancar a excecao IdadeInvalidaEXception
        }
    }
}
