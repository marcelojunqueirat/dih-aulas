package aula03.pratica;

public class Gerente extends Funcionario implements Autenticavel {

    @Override
    public boolean autenticar(String usuario, String senha) {
        return usuario.equals("gerentao") && senha.equals("1234");
    }

}
