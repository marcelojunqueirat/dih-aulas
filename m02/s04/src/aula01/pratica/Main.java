package aula01.pratica;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Double numero1 = null, numero2= null;
        try {
            System.out.println("Informe o primeiro número:");
            numero1 = sc.nextDouble();
            System.out.println("Informe o segundo número:");
            numero2 = sc.nextDouble();
        } catch (InputMismatchException e) {  // InputMismatchException é sub-classe de Exception
            System.out.println("A entrada fornecida nao foi do tipo esperado!!!");
            return;
        }

        System.out.println("Qual a operação desejada:");
        System.out.println("1 - Adição");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        int op = sc.nextInt();

        Operacao operacao = null;
        switch (op) {
            case 1 -> operacao = new Adicao();
            case 2 -> operacao = new Subtracao();
            case 3 -> operacao = new Multiplicacao();
            case 4 -> operacao = new Divisao();
        }

        try {
            validarOperacao(operacao);
        } catch (CalculadoraException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.printf("A operação escolhida foi: %s. O resultado é: %.2f.",
                operacao.getDescricao(),
                operacao.calcular(numero1, numero2));
    }


    private static void validarOperacao(Operacao operacao) throws CalculadoraException {
        if (operacao == null)
            throw new CalculadoraException("Operacao nao identificada!");
    }

}
