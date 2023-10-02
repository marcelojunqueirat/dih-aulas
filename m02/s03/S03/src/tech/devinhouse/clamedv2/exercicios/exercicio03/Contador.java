package tech.devinhouse.clamedv2.exercicios.exercicio03;

import java.util.StringTokenizer;

public class Contador {

    public static int contarPalavras(String frase) {
        if (frase == null)
            return 0;
        String[] palavras = frase.split(" ");
        return palavras.length;
//        StringTokenizer tokenizer = new StringTokenizer(frase, " ");
//        return tokenizer.countTokens();
    }

}
