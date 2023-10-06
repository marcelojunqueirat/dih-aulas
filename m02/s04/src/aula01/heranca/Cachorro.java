package aula01.heranca;

public class Cachorro extends Mamifero {

    private String corDoPelo;

    @Override
    public void emitirSom() {

        super.qtdMamas = 10;
        super.nome = "Cachorrinha";

        System.out.println("latir");
    }

}
