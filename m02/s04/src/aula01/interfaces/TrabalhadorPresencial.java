package aula01.interfaces;

public class TrabalhadorPresencial implements Trabalhador {

    public void tomarCafeDaEmpresa() {
        System.out.println("Tomei o café da empresa");
    }

    @Override
    public void baterPonto() {
        System.out.println("Bate o ponto via biometria");
    }

}
