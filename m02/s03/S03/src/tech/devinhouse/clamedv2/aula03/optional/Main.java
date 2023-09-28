package tech.devinhouse.clamedv2.aula03.optional;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        // fingindo que buscamos o nome no BD
//        String nome = null;

        Optional<String> nomeOpt = Optional.of("tiago");

//        if (nome != null)
//            System.out.println( nome.toUpperCase() );

        if (nomeOpt.isPresent()) {
            String nome = nomeOpt.get();
            System.out.println( nome);
        } else {
            System.out.println("Nao tinha nome lá dentro");
        }

        Optional<Integer> idadeOpt = Optional.of(23);

    }

}
