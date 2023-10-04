package aula02.calculadora;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Informe o primeiro número:");
            double numero1 = sc.nextDouble();
            System.out.println("Informe o segundo número:");
            double numero2 = sc.nextDouble();

            System.out.println("Qual a operação desejada:");
            System.out.println("1 - Adição");
            System.out.println("2 - Subtração");
            System.out.println("3 - Multiplicação");
            System.out.println("4 - Divisão");
            int op = sc.nextInt();
            validarOperacao(op);

            Operacao operacao;
            switch (op) {
                case 1 -> operacao = new Adicao();
                case 2 -> operacao = new Subtracao();
                case 3 -> operacao = new Multiplicacao();
                case 4 -> operacao = new Divisao();
                default -> operacao = null;
            }

            System.out.printf("A operação escolhida foi: %s. O resultado é: %.2f.", operacao.getDescricao(), operacao.calcular(numero1, numero2));
        } catch (CalculadoraException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado. Contate o administrador.");
        }
    }

    public static void validarOperacao(int op) throws CalculadoraException {
        if (op < 1 || op > 4)
            throw new CalculadoraException("Operação inexistente ou inválida!");

    }
}
