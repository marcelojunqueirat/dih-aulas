package aula01.interfaces;

public class TrabalhadorHomeOffice implements Trabalhador {

    @Override
    public void baterPonto() {
        System.out.println("Bate o ponto via sistema");
    }

}
