package aula03.comparacoes;

import java.util.concurrent.Callable;

public class MainTrabalhavel {

    public static void main(String[] args) {

        Trabalhavel trab = dias -> System.out.println("trabalhei");

        Runnable runnable = () -> System.out.println("rodou");

        Callable<Funcionario> callable = () -> new Funcionario();

    }
}
