package aula04.records;

public class Main {

    public static void main(String[] args) {

        System.out.println("Usando classe pessoa");
        Pessoa pessoa = new Pessoa(123L, "tiago");
        pessoa.getCpf();
        pessoa.getNome();
        System.out.println(pessoa);

        System.out.println();

        System.out.println("Usando Record pessoa");
        PessoaRecord pessoa2 = new PessoaRecord(321L, "marconi");

        pessoa2.cpf();
        pessoa2.nome();
        System.out.println(pessoa2);

    }

}
