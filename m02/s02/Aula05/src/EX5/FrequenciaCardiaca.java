package EX5;

import java.time.LocalDate;

public class FrequenciaCardiaca {
    private String nome;
    private String sobrenome;
    private String dataNascimento;

    public FrequenciaCardiaca(String nome, String sobrenome, String dataNascimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int calculaIdade() {
        LocalDate atual = LocalDate.now();
        int anoAtual = atual.getYear();
        int mesAtual = atual.getMonthValue();
        int diaAtual = atual.getDayOfMonth();

        String[] dataNasc = this.dataNascimento.split("/");
        int anoNascimento = Integer.parseInt(dataNasc[2]);
        int mesNascimento = Integer.parseInt(dataNasc[1]);
        int diaNascimento = Integer.parseInt(dataNasc[0]);

        int idade = anoAtual - anoNascimento;
        if (mesAtual < mesNascimento) {
            idade--;
        } else if (mesAtual == mesNascimento) {
            if (diaAtual < diaNascimento){
                idade--;
            }
        }

        return idade;
    }

    public int frequenciaCardiacaMaxima() {
        return 220 - calculaIdade();
    }

    public double[] frequenciaCardiacaAlvo() {
        double[] intervaloFreqCardAlvo = new double[2];
        intervaloFreqCardAlvo[0] = frequenciaCardiacaMaxima() * 0.5;
        intervaloFreqCardAlvo[1] = frequenciaCardiacaMaxima() * 0.85;
        return  intervaloFreqCardAlvo;
    }
}
