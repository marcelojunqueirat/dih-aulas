package banco;

public class Conta {
    String nomeTitular;
    private double saldo;

    void sacar(double valor){
        if (valor <= this.saldo){
            this.saldo -= valor;
        } else {
            System.out.println("Não foi possível realizar o saque. Consulte seu saldo.");
        }
    }

    void depositar(double valor){
        this.saldo += valor;
    }

    double getSaldo() {
        return this.saldo;
    }

    String getNomeTitular(){
        return this.nomeTitular;
    }
}
