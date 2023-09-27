package tech.devinhouse.clamedv2.aula01.pratica1;

public class Main {

    public static void main(String[] args) {

        var pessoa = new Pessoa();

        pessoa.setNome("tiago");
        pessoa.setSobrenome("Albuquerque");
        pessoa.setIdade(22);

        var nomeCompleto = pessoa.obterNomeCompleto();
        var idadeEmMeses = pessoa.obterIdadeEmMeses();

        System.out.println(nomeCompleto);
        System.out.println(idadeEmMeses + " meses");

    }

}
