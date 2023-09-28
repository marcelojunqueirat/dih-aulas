package tech.devinhouse.clamedv2.aula02.sobrecarga;

public class Main {

    public static void main(String[] args) {

        var sobrecarga = new Sobrecarga();

        String resultado = sobrecarga.obterDadosFormatados("sapato");
        String resultadoMaisculo = sobrecarga.obterDadosFormatados("tiago", 1);



        System.out.println(resultado);
        System.out.println(resultadoMaisculo);

    }

}
