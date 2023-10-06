package aula03.comparacoes;

import java.time.LocalDate;
import java.util.*;

public class MainComparacao {

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

//        Collections.sort(lista); // ordenando a lista pela ordenacao natural (Comparable)

        DataAdmissaoComparator comparadorPorDataDeAdmissao = new DataAdmissaoComparator();
        lista.sort(comparadorPorDataDeAdmissao);
        System.out.println(lista);

        NomeComparator comparadorPorNome = new NomeComparator();
        lista.sort(comparadorPorNome);
        System.out.println(lista);

        lista.sort(comparadorPorNome.thenComparing(comparadorPorDataDeAdmissao));

    }

}
