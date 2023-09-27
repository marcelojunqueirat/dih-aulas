package tech.devinhouse.clamedv2.aula02.construtores;

public class Principal {

    public static void main(String[] args) {

        var john = new Pessoa("john", 123456L, 22);
        john.setNome("j snow");
        System.out.println(john);

        var sansa = new Pessoa();
        sansa.setNome("sansa stark");
        System.out.println(sansa);

        var arya = new Pessoa("Arya");
        System.out.println(arya);

        // tyrion - 30
        var tyrion = new Pessoa("tyrion", 30);
        System.out.println(tyrion);

    }

}
