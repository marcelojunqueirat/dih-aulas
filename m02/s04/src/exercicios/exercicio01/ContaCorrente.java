package exercicios.exercicio01;

public class ContaCorrente extends Conta implements Operavel {

    @Override
    protected double obterSaldoAtual() {
        return super.saldo;  // super indicando que veio da super-classe
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;  // mesma coisa que saldo = saldo + valor
    }

    @Override
    public double sacar(double valor) {
        this.saldo -= valor;  // mesma coisa que saldo = saldo - valor
        return this.saldo;
    }

}
