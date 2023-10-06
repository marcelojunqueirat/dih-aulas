package aula03.pratica;

public class Main {

    public static void main(String[] args) {

        Funcionario diretor = new Diretor();
        diretor.setNome("andre");
        System.out.println(diretor.getNome());

        Autenticavel diretor2 = new Diretor();
        diretor2.autenticar("bla", "ble");

    }

}
