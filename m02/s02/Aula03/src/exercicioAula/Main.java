package exercicioAula;

public class Main {
    public static void main(String[] args) {
        Carro carro1 = new Carro("Prata", "GM ASTRA", 220);
        System.out.println(carro1);
        System.out.println("----------------------------------------------------");

        // tentando acelerar sem ligar
        carro1.acelerar(50);
        System.out.println("----------------------------------------------------");

        carro1.ligar();
        carro1.acelerar(140);
        System.out.println(carro1);
        System.out.println("----------------------------------------------------");

        carro1.ligar();
        carro1.frear(20);
        System.out.println(carro1);
        System.out.println("----------------------------------------------------");

        System.out.println(carro1.buzinar());
    }
}
