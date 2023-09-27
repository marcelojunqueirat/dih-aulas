package tech.devinhouse.clamedv2.aula01.modificadores;

public class MainModificadores {

    public static void main(String[] args) {

        var teste = new TesteDeModificadores();

        teste.atributo = "sapato";
        System.out.println(teste.atributo);

        String resultado = teste.lancarFoguete();

    }

}
