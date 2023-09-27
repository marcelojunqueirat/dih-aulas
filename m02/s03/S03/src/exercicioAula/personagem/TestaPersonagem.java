package exercicioAula.personagem;

import java.time.LocalDateTime;
import java.util.Scanner;

public class TestaPersonagem {
    public static void main(String[] args) {
        var personagem = new Personagem();

        Scanner sc = new Scanner(System.in);

        System.out.println("Informe nome do personagem: ");
        String nome = sc.nextLine();

        System.out.println("Qual a referencia? Escolha: 1 para SERIE | 2 para FILME: ");
        String referenia = sc.nextLine();

        System.out.println("Informe a idade do personagem: ");
        Integer idade = Integer.parseInt(sc.nextLine());

        LocalDateTime dataAtual = LocalDateTime.now();

        personagem.setNome(nome);
        personagem.setIdade(idade);
        personagem.setDataDeCadastro(dataAtual);
        personagem.setReferencia( referenia.equals("1") ? Referencia.SERIE: Referencia.FILME);

        System.out.println(personagem.obterNomeEmMaiusculo());
        System.out.println(personagem.obterTresPrimeirasLetrasDoNome());
        System.out.println(personagem.toString());

    }
}
