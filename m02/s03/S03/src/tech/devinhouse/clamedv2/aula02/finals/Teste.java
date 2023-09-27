package tech.devinhouse.clamedv2.aula02.finals;

import tech.devinhouse.clamedv2.aula02.finals.Pessoa;

public class Teste {

    public static void main(String[] args) {

        final int idade = 30; // constante
        final String nome = "james kirk";
        final Pessoa john = new Pessoa("john", 123L, "black");
        john.setNomeSocial("john snow know nothing");

        // nao compila, pq variaveis acima se tornaram constantes com 'final'
//        idade = 40;
//        nome = "spock";
//        john = new Pessoa("sansa");

    }

}
