package tech.devinhouse.clamedv2.exercicios.exercicio04;

public class Main {

    public static void main(String[] args) {
        Contador2 contador = new Contador2("Luke, I am your father!");
        int qtdPalavras = contador.contarPalavras();
        System.out.println(qtdPalavras);
    }

}
