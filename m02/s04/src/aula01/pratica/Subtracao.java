package aula01.pratica;

public class Subtracao implements Operacao {

    @Override
    public double calcular(double valor1, double valor2) {
        return valor1 - valor2;
    }

    @Override
    public String getDescricao() {
        return "Subtração";
    }

}
