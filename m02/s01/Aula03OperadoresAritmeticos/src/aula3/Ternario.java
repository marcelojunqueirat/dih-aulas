package aula3;

public class Ternario {
    public static void main(String[] args) {
        int idade = 18;
        String maioridade = (idade >= 18) ? "adulto" : "menor de idade";
        System.out.println(maioridade);

        int num = 3;
        boolean ehPar = num % 2 == 0;// ? true : false;
        String parOuimpar = num % 2 == 0 ? "par" : "impar" ;
        System.out.printf("O numero %d é %s.", num, parOuimpar );
    }
}
