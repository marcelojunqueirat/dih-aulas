package tech.devinhouse.clamedv2.aula02.statics;

public class Animal {

    public static int contador = 0;

    public Animal() {
        contador++;
    }

    public static void comer() {
        System.out.println("Animal comeu");
    }

}
