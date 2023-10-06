package aula01.heranca;

public abstract class Animal {

    protected String nome;

    public abstract void emitirSom();

    public void caminhar() {
        System.out.println("caminhando");
    }

}
