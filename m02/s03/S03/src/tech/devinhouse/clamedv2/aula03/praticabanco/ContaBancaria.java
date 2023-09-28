package tech.devinhouse.clamedv2.aula03.praticabanco;

import java.time.LocalDateTime;

public class ContaBancaria {

    private String nomeBanco;
    private Integer agencia;
    private Integer conta;
    private double saldo;
    private Cliente cliente;
    private LocalDateTime dataCriacao;


    public void sacar(double valor) {
        this.saldo -= valor; // mesma coisa que this.saldo = this.saldo - valor;
    }


    @Override
    public String toString() {
        return "ContaBancaria{" +
                "nomeBanco='" + nomeBanco + '\'' +
                ", agencia=" + agencia +
                ", conta=" + conta +
                ", saldo=" + saldo +
                ", cliente=" + cliente +
                ", dataCriacao=" + dataCriacao +
                '}';
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getConta() {
        return conta;
    }

    public void setConta(Integer conta) {
        this.conta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
