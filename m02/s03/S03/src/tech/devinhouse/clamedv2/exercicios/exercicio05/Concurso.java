package tech.devinhouse.clamedv2.exercicios.exercicio05;

import java.time.LocalDate;
import java.util.Arrays;

public class Concurso {

    private int numero;

    private LocalDate data;

    private int[] sorteados;


    public Concurso() { }

    public Concurso(int numero, LocalDate data, int[] sorteados) {
        this.numero = numero;
        this.data = data;
        this.sorteados = sorteados;
    }


    @Override
    public String toString() {
        return "Concurso{" +
                "numero=" + numero +
                ", data=" + data +
                ", sorteados=" + Arrays.toString(sorteados) +
                '}';
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int[] getSorteados() {
        return sorteados;
    }

    public void setSorteados(int[] sorteados) {
        this.sorteados = sorteados;
    }
}
