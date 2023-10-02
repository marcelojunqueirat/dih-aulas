package tech.devinhouse.clamedv2.exercicios.exercicio04;

public class Contador2 {

    private String frase;

    public Contador2(String frase) {
        this.frase = frase;
    }

    public int contarPalavras() {
        if (this.frase == null)
            return 0;
        String[] palavras = this.frase.split(" ");
        return palavras.length;
//        StringTokenizer tokenizer = new StringTokenizer(this.frase, " ");
//        return tokenizer.countTokens();
    }

}
