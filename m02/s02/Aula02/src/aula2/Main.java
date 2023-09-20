package aula2;

public class Main {
    public static void main(String[] args) {
        Carro unoDeFirma = new Carro();
        unoDeFirma.cor = "Branco";
        unoDeFirma.possuiEscada = true;
        unoDeFirma.ano = 2005;
        unoDeFirma.numPortas = 2;

        unoDeFirma.acelerar(2);
        double velocidadeUninho = unoDeFirma.acelerar(5);

        System.out.println(velocidadeUninho);

        Carro sandero = new Carro();
        sandero.cor = "Prata";
        sandero.possuiEscada = false;
        sandero.ano = 2015;
        sandero.numPortas = 4;

        sandero.acelerar(3);
        sandero.acelerar(1);
        double velocidadeSandero = sandero.frear(2);

        System.out.println(velocidadeSandero);

    }
}
