package tech.devinhouse.clamedv2.aula03.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Principal {

    public static void main(String[] args) {

        // filter, map, reduce, find , forEach ...

        List<String> nomes = List.of("tiago", "gustavo", "antonio", "leonardo", "alvaro");

        nomes.stream()
                .filter(n -> n.startsWith("a"))
                .map(n -> n.toUpperCase())
                .forEach(n -> System.out.println(n));

        List<String> nomesEmMaisculo = nomes.stream()
                .map(n -> n.toUpperCase()).toList();

        System.out.println(nomes);
        System.out.println(nomesEmMaisculo);
    }

}
