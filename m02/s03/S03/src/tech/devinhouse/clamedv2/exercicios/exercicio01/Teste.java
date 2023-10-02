package tech.devinhouse.clamedv2.exercicios.exercicio01;

public class Teste {

    public static void main(String[] args) {

        Funcionario funcionario1 = new Funcionario();
        funcionario1.setCpf(12345678901L);
        funcionario1.setNomeCompleto("James Kirk");
        funcionario1.setSalario(10_000F);

        Funcionario funcionario2 = new Funcionario(98765432123L,
                "Leonard McCoy", 8_000F);

        funcionario1.promover(30F);
        System.out.println("O salario atual do primeiro funcionario é "
                + funcionario1.getSalario() );

        funcionario2.promover(20F);
        System.out.println(String.format("O salario atual do segundo funcionario é %.2f",
                funcionario2.getSalario()));

    }

}
