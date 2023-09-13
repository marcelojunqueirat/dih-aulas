package org.example;

public class TiposDeDados {
    public void tipoDeDados(){
        /* TIPOS PRIMITIVOS */
        int numeroDeCachorros = 2;
        double peso = 7.2;
        System.out.println("Peso do meu cão é: " + peso + "kg.");

        boolean ehCastrado = true;

        float altura = 1.92f;
        System.out.printf("Meu nome é %s e minha altura é: %.2f. %n", "Marcelo", altura);

        long id = 12300000000L;
        char primeiraLetraDoNome = 'M';

        /* typecasting */
        int altura2 = (int) 1.75;
        System.out.println("Minha altura é: " + altura2);

        /* TIPOS POR REFERENCIA WRAPPER CLASS */
        String nomeCompletoPai = "João José";
        Double precoDoCigarroQueOPaiFoiComprar = 8.5;
        precoDoCigarroQueOPaiFoiComprar = null;
    }
}
