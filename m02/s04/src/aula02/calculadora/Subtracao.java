package aula02.calculadora;

public class Subtracao implements Operacao {
    @Override
    public Double calcular(double numero1, double numero2) {
        return numero1 - numero2;
    }

    @Override
    public String getDescricao() {
        return "Subtração";
    }
}
