package aula01.heranca;

public class Zebra extends Animal {

    int qtdListras;

    @Override // sobrescrita
    public void emitirSom() {
        System.out.println(super.nome);
        System.out.println("zurrar");
    }

}
