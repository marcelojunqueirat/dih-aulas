package tech.devinhouse.clamedv2.aula01.bancario;

public class Conta {

    // atributos
    private Cliente cliente;
    private double saldo;

    // métodos
    public void sacar(double valor) {
//        saldo = saldo - valor;
        this.saldo -= valor;
    }

    public double getValor() {
        return this.saldo;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
