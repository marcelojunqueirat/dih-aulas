package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*TiposDeDados tiposDeDados = new TiposDeDados();
        tiposDeDados.tipoDeDados();*/

        Scanner entrada = new Scanner(System.in);

        System.out.println("Qual seu nome?");
        String nomeUsuario = entrada.nextLine();

        System.out.println("Qual sua idade?");
        int idade = Integer.parseInt(entrada.nextLine());

        System.out.println("Qual sua altura?");
        //double altura = entrada.nextDouble();
        double altura = Double.parseDouble(entrada.nextLine());

        System.out.format("O usuário %s tem %d anos e mede %.2fm. %n", nomeUsuario, idade, altura);
        System.out.printf("O nome %s tem %d caracteres.%n", nomeUsuario, nomeUsuario.length());

        System.out.println(nomeUsuario.toUpperCase());
        System.out.println(nomeUsuario.toLowerCase());

        System.out.println("   Testando o Trim    ".trim());

        System.out.println("Marcelo".equals("marcelo"));
        System.out.println("Marcelo".equalsIgnoreCase("marcelo"));

        System.out.println("Marcelo".charAt(2));
        System.out.println("Marcelo".indexOf('r'));
        System.out.println("Marcelo".indexOf('c'));
        System.out.println("Marcelo".indexOf('v'));

        System.out.println("Mariana".lastIndexOf('a'));

        System.out.println("testando".replace('t', 'T'));


        String nomeTesteSubstr = "Marcelo Junqueira";
        int indexDoEspaco = nomeTesteSubstr.indexOf(" ");
        String primeiroNome = nomeTesteSubstr.substring(0, indexDoEspaco);
        String segundoNome = nomeTesteSubstr.substring(indexDoEspaco+1);

        System.out.println("Primeiro nome: " + primeiroNome);
        System.out.println("Segundo nome: " + segundoNome);

        String idadeStr = Integer.toString(idade);
        double peso = Double.parseDouble("10.5");

/*        System.out.println(idade);
        System.out.println(peso);*/
    }
}