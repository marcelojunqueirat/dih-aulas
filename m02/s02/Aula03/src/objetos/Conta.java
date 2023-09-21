package objetos;

public class Conta {

    Cliente titular;
    private double saldo;

    public Conta(Cliente titular) {
        this.titular = titular;
    }

    public Conta(Cliente titular, double saldo) {
        this(titular);
        this.saldo = saldo;
    }

    public Conta(){

    }

    boolean sacar(double valor){
        if (valor <= this.saldo){
            this.saldo -= valor;
            return true;
        } else {
            System.out.println("Não foi possível realizar o saque. Consulte seu saldo.");
            return false;
        }
    }

    void depositar(double valor){
        this.saldo += valor;
    }

    double getSaldo() {
        return this.saldo;
    }

    String getNomeTitular(){
        return this.titular.nome;
    }

    public void transferir(Conta contaDestino, double valor) {
        if(this.sacar(valor)){
            contaDestino.depositar(valor);
        }
    }

    public String toString() {
        return String.format("O nome do titular é %s. Seu saldo é de R$%.2f.", this.titular.nome, this.getSaldo());
    }
}

