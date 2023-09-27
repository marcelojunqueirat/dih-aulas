package tech.devinhouse.clamedv2.aula02.statics;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Testes {

    public static void main(String[] args) {

        var resultado = Math.pow(2, 3);

        System.out.println(resultado); // 8

        LocalDate ontem = LocalDate.of(2023, 9, 25);
        LocalDate hoje = LocalDate.now();

        Animal.comer();
        System.out.println( Animal.contador ); // 0

        Animal animal1 = new Animal();  // contador == 1
        Animal animal2 = new Animal();  // contador == 2

        System.out.println( Animal.contador ); // 2

        DataUtils.formatarData(LocalDate.now());

        DataUtils dataUtils = new DataUtils();

    }

}
