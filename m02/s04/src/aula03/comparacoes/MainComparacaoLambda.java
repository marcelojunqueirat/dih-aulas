package aula03.comparacoes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MainComparacaoLambda {

    public static void main(String[] args) {

        Funcionario gustavo = new Funcionario(333, "gustavo",
                LocalDate.of(2023, 10, 4));
        Funcionario alvaro = new Funcionario(222, "alvaro",
                LocalDate.of(2023, 10, 3));
        Funcionario patricia = new Funcionario(111, "patricia",
                LocalDate.of(2023, 10, 5));
        Funcionario antonio = new Funcionario(444, "antonio",
                LocalDate.of(2023, 10, 2));

        List<Funcionario> lista = new ArrayList<>();
        lista.add(gustavo);
        lista.add(alvaro);
        lista.add(patricia);
        lista.add(antonio);

        // Usando classe externa
//        NomeComparator comparadorPorNome = new NomeComparator();

        // Usando funcao lambda
        Comparator<Funcionario> comparadorPorNome =
                (funcionario1, funcionario2) ->
                funcionario1.getNome().compareTo(funcionario2.getNome());

        // Usando o metodo estatico 'comparing' da classe Comparator
        Comparator<Funcionario> comparadorPorNome2 =
                Comparator.comparing(f -> f.getNome());

        // Usando a referencia do metodo para fazer a comparacao
        Comparator<Funcionario> comparadorPorNome3 =
                Comparator.comparing(Funcionario::getNome);

        lista.sort(comparadorPorNome);
        System.out.println(lista);

    }

}
