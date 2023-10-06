package aula01.interfaces;

public class Main {

    public static void main(String[] args) {

        TrabalhadorHomeOffice trabalhadorHomeOffice = new TrabalhadorHomeOffice();
        trabalhadorHomeOffice.baterPonto();
        trabalhadorHomeOffice.tomarCafe();

        TrabalhadorPresencial trabalhadorPresencial = new TrabalhadorPresencial();
        trabalhadorPresencial.baterPonto();
        trabalhadorPresencial.tomarCafeDaEmpresa();

        EstagiarioHomeOffice estagiarioHomeOffice = new EstagiarioHomeOffice();
        estagiarioHomeOffice.baterPonto();

        Trabalhador presencial = new TrabalhadorPresencial();
        presencial.baterPonto();

        TrabalhadorPresencial trab = (TrabalhadorPresencial) presencial;  // casting

    }

}
