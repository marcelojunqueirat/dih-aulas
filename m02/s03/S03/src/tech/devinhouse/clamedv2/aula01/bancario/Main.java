package tech.devinhouse.clamedv2.aula01.bancario;

public class Main {

    public static void main(String[] args) {

        // criando uma conta e indicando atributos
        var conta = new Conta();
        conta.setSaldo(1000);

        // criando um cliente e indicando atributos
        var cliente = new Cliente();
        cliente.setNome("John");
        cliente.setSobrenome("Snow");
        cliente.setCpf(12345678901L);

        var cliente2 = new Cliente();

        // indicando o cliente na conta criada
        conta.setCliente(cliente);

        // chamando metodo
        conta.sacar(20);

    }

}