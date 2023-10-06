package aula03.comparacoes;

import java.time.LocalDate;
import java.util.List;

public class MainEquals {

    public static void main(String[] args) {

        Gato gato1 = new Gato("Garfield", "laranja"); // obj1
        Gato gato2 = new Gato("Garfield", "laranja"); // obj2
        Gato gato3 = gato1;

        System.out.println( gato1 == gato2 );  // false
        System.out.println( gato1 == gato1 );  // true
        System.out.println( gato1 == gato3 );  // true

        System.out.println("---");

        System.out.println( gato1.equals(gato2) ); // true

        System.out.println("--- ----");

        Funcionario func1 = new Funcionario(123, "Gustavo", LocalDate.of(2023, 10, 4)); // veio do sistema 1
        Funcionario func2 = new Funcionario(123, "gustavo", LocalDate.of(2023, 10, 4)); // veio do sistema 2

        if ( func1.equals(func2) ) {
            System.out.println("Eh o mesmo cara");
        } else {
            System.out.println("Nao eh o mesmo cara");
        }

        List<Funcionario> listaFunc = List.of(
                new Funcionario(123, "Gustavo"),
                new Funcionario(123, "gustavo"));

        boolean contem = listaFunc.contains(func1);
        System.out.println(contem);


    }

}
