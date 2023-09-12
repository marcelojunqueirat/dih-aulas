package devinhouse.clamed;

public class Hello {
    public static void main(String[] args) {
        String nome = "Zé Ruela";
        nome = "Testando";

        int idade = 30;
        idade = 50;

        char letra = 'a';

        double altura = 1.89;

        boolean casado = true;

        final String NOME_DA_MAE = "Mother";

        System.out.println(nome);
        System.out.println("Javeiros");
        System.out.println(NOME_DA_MAE);
    }

    public void outroMetodoTeste(String nomeCompleto){
        System.out.println(nomeCompleto);
    }
}
