package aula03.pratica;

public class Diretor extends Funcionario implements Autenticavel {

    @Override
    public boolean autenticar(String usuario, String senha) {
        return usuario.equals("diretorzao") && senha.equals("1234");
    }

}
