package exercicioAula;

public class Carro {
    String cor;
    String modelo;
    boolean ligado;
    int velocidadeAtual = 0;
    int velocidadeMaxima;

    public Carro(String cor, String modelo, int velocidadeMaxima){
        this.cor = cor;
        this.modelo = modelo;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public Carro(){
    }

    void ligar(){
        this.ligado = true;
    }

    void desligar(){
        this.ligado = false;
    }

    void acelerar(int aceleracao){
        int velocidadeAtualAux = this.velocidadeAtual;
        if(!this.ligado){
            System.out.println("Para acelerar, é necessário ligar o carro.");
        } else if ((velocidadeAtualAux += aceleracao) < this.velocidadeMaxima ) {
            this.velocidadeAtual += aceleracao;
        } else{
            System.out.printf("Para sua segurança, não é possível aumentar a velocidade. Velocidade máxima permitida: %d.%n", this.velocidadeMaxima);
        }
    }

    void frear(int frenagem){
        int velocidadeAtualAux = this.velocidadeAtual;
        if((velocidadeAtualAux -= frenagem) < 0){
            this.velocidadeAtual =0;
        } else {
            this.velocidadeAtual -= frenagem;
        }
    }
     String buzinar(){
        return "beep beep";
     }

    public String toString(){
        return String.format("O carro é um %s, de cor %s de velocidade máxima de %d km/h. Velocidade Atual: %d km/h. Estado do motor: %s", this.modelo, this.cor, this.velocidadeMaxima, this.velocidadeAtual, (this.ligado ? "Ligado" : "Desligado"));
    }

}
