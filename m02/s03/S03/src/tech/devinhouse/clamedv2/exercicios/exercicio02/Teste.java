package tech.devinhouse.clamedv2.exercicios.exercicio02;

public class Teste {

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("tiago");
        funcionario.setSalario(1000F);
        funcionario.aumentar(500F);
        System.out.println(funcionario.getSalario()); // 1500
        funcionario.aumentar(300F, 30F);
        System.out.println(funcionario.getSalario()); // 1830
    }

}
