package aula01.interfaces;

public interface Trabalhador {

    void baterPonto();

    // default methods
    default void tomarCafe() {
        System.out.println("Tomando café");
    }

}
