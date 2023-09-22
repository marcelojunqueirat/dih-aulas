package br.senai.lab365.devinhouse.entidades;

public class Conta {
    public static int totalContas;
    private Cliente titular;
    private double saldo;
    private boolean ativa;
    private double limite;

    public Conta(){Conta.totalContas++; }

    public Conta(Cliente titular) {
        this.titular = titular;
    }

    public Conta(Cliente titular, double saldo) {
        this(titular);
        this.saldo = saldo;
    }

    public Conta(Cliente titular, double saldo, double limite) {
        this(titular);
        this.saldo = saldo;
        this.limite = limite;
    }

    public boolean sacar(double valor){
        double saldoComLimite = this.saldo + this.limite;
        if (valor <= saldoComLimite){
            this.saldo -= valor;
            return true;
        } else {
            System.out.println("Não foi possível realizar o saque. Consulte seu saldo.");
            return false;
        }
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public double getSaldo() {
        return this.saldo + this.limite;
    }

    public String getNomeTitular(){
        return this.titular.getNome();
    }

    public void transferir(Conta contaDestino, double valor) {
        if(this.sacar(valor)){
            contaDestino.depositar(valor);
        }
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getLimite(){
        return this.limite;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public static int getTotalContas() {
        return totalContas;
    }

    public String toString() {
        return String.format("O nome do titular é %s. Seu saldo é de R$%.2f.", this.titular.getNome(), this.getSaldo());
    }
}

