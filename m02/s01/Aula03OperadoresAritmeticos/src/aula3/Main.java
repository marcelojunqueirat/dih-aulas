package aula3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int idade = 32;
        System.out.println(idade + 1);
        System.out.println("Minha idade é " + (idade + 1));
        System.out.printf("Minha idade é %d. %n", idade + 1);

        double peso = 85.5;
        peso = peso - 2;
        System.out.println("Meu peso é: " + peso);

        double preco = 5.2;
        int quantidade = 3;
        double valorTotalCompra = preco * quantidade;
        System.out.printf("Valor pago: R$%.2f.%n", valorTotalCompra);

        int quantidadePessoas = 2;
        double valorPagoPessoa = valorTotalCompra / quantidadePessoas;
        System.out.printf("Valor por pessoa: R$%.2f.%n", valorPagoPessoa );

        double restoDaDivisao = valorTotalCompra % quantidadePessoas;
        System.out.printf("Resto da divisão valor por pessoa: %.2f.%n", restoDaDivisao);

        double resultado1 = 3.0 + 4.0 * 2.0;
        double resultado2 = (1.0 + 4.0) / 2.0;
        double resultado3 = (6.0 - 2.0) % 3.0;
        System.out.println(resultado1);
        System.out.println(resultado2);
        System.out.println(resultado3);

        //idade +=2;
        //idade++;
        System.out.println("Idade incrementada: " + ++idade);

        //idade -=3;
        //idade--;
        System.out.println("Idade decrementada: " + --idade);

        System.out.printf("Preço atual: R$%.2f%n", preco);
        preco *= 1.2;
        System.out.printf("Preço atual com acrescimo de 20%%: R$%.2f%n", preco);

        double resultPow = Math.pow(5, 2);
        System.out.printf("Potência de 5^2: %.2f.%n", resultPow);

        double raizQuadrada = Math.sqrt(25);
        System.out.printf("Raiz Quadrada de 9: %.2f.%n", raizQuadrada);

        double raizCubica = Math.cbrt(27);
        System.out.printf("Raiz Cubica de 27: %.2f.%n", raizCubica);

        int resultAbs = Math.abs(-10);
        System.out.println(resultAbs);

        double floor = Math.floor(19.9);
        System.out.println(floor);

        double ceil = Math.ceil(20.1);
        System.out.println(ceil);

        double round = Math.round(19.6);
        System.out.println(round);

        System.out.println(Math.PI);

        System.out.println(Math.random());

        double aleatorio = Math.random() * (10-5) + 5;
        System.out.printf("Número aleatório entre 5 e 10: %.2f%n", aleatorio);

        int intAleatorio = (int) (Math.random() * (100-10) + 10);
        System.out.printf("Número aleatório inteiro entre 10 e 100: %d.%n", intAleatorio);

        String str1 = new String("str");
        String str2 = new String("str");
        //System.out.println(str1 == str2); //falso, nao compara conteudo e sim referencia (wrapper class) usar sempre equals
        System.out.println(str1.equals(str2));

        System.out.println((5>3) && (8==9));
        System.out.println((5>3) || (8==9));

        Scanner entrada = new Scanner(System.in);
        System.out.println("Qual sua idade?");
        int idadeUsuario = Integer.parseInt(entrada.nextLine());
        if (idadeUsuario < 0) {
            System.out.println("Idade obrigatorio, insira um valor:");
            idadeUsuario = Integer.parseInt(entrada.nextLine());
        }
        if (idadeUsuario >= 18){
            System.out.println("Você já pode tirar CNH.");
        } else {
            System.out.println("Você não pode tirar CNH.");
        }
        System.out.printf("Sua idade é %d%n", idadeUsuario);

        System.out.println("Qual o nome da sua mae?");
        String nomeDaMae = entrada.nextLine();
        if(nomeDaMae != null && !nomeDaMae.isBlank() ) {
            System.out.println(nomeDaMae);
        } else {
            System.out.println("Nome da mãe é obrigatorio.");
            nomeDaMae = entrada.nextLine();
            System.out.println(nomeDaMae);
        }

        System.out.println("Qual sua data de nascimento? formato dd/MM/yyyy");
        String dataNascimento = entrada.nextLine();
        String mesNascimento = dataNascimento.substring(3,5);
        String result = "";

        switch (mesNascimento) {
            case "01":
                result = "Janeiro";
                break;
            case "02":
                result = "Fevereiro";
                break;
            case "03":
                result = "Março";
                break;
            case "04":
                result = "Abril";
                break;
            case "05":
                result = "Maio";
                break;
            case "06":
                result = "Junho";
                break;
            case "07":
            case "08":
            case "09":
            case "10":
            case "11":
            case "12":
                result = "Segundo semestre";
                break;
            default:
                result = "Mês invalido";
        }

        System.out.println(result);

    }
}