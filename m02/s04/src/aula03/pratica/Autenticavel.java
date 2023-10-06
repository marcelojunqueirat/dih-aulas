package aula03.pratica;

@FunctionalInterface
public interface Autenticavel {

    boolean autenticar(String usuario, String senha);

}
