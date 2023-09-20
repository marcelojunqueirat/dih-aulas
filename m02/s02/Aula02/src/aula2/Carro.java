package aula2;

public class Carro {
    int numPortas;
    String cor;
    int ano;
    boolean possuiEscada;
    private double velocidade;

    double acelerar(double aceleracao) {
        this.velocidade += aceleracao;
        return this.velocidade;
    }

    double frear(double frenagem) {
        this.velocidade -= frenagem;
        return this.velocidade;
    }
}
