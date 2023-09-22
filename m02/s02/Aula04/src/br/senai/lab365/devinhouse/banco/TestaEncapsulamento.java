package br.senai.lab365.devinhouse.banco;

import br.senai.lab365.devinhouse.entidades.Cliente;
import br.senai.lab365.devinhouse.entidades.Conta;


public class TestaEncapsulamento {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("Marcelo");
        cliente.setSobrenome("Teste");
        cliente.setCpf("66633399901");

        Conta minhaConta = new Conta(cliente, 50, 100);

        minhaConta.sacar(60);
        System.out.println(minhaConta);
    }
}
