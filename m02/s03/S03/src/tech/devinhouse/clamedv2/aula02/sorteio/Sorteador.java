package tech.devinhouse.clamedv2.aula02.sorteio;

import java.util.Random;

public class Sorteador {

    public static int sortear() {
        return new Random().nextInt(100) + 1;
    }

}
