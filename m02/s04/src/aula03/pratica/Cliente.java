package aula03.pratica;

public class Cliente implements Autenticavel {
    @Override
    public boolean autenticar(String usuario, String senha) {
        return usuario.equals("clientao") && senha.equals("1234");
    }
}
