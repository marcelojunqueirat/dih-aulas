package tech.devinhouse.clamedv2.aula01.modificadores;

public class TesteDeModificadores {

    public String atributo;

    public String lancarFoguete() {
        ligarIgnicao();
        desencadearCombustao();
        return "lançado";
    }

    private String ligarIgnicao() {
        return "Ligado";
    }

    private String desencadearCombustao() {
        return "bla";
    }


}
