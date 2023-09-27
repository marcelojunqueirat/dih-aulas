package exercicioAula.personagem;

import java.time.LocalDateTime;

public class Personagem {
    private String nome;
    private Referencia referencia;
    private Integer idade;
    private LocalDateTime dataDeCadastro;

    public String obterNomeEmMaiusculo(){
        return this.nome.toUpperCase();
    }

    public String obterTresPrimeirasLetrasDoNome(){
        return this.nome.substring(0, 3);
    }

    @Override
    public String toString() {
        return "Personagem{" +
                "nome='" + nome + '\'' +
                ", referencia=" + referencia +
                ", idade=" + idade +
                ", dataDeCadastro=" + dataDeCadastro +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Referencia getReferencia() {
        return referencia;
    }

    public void setReferencia(Referencia referencia) {
        this.referencia = referencia;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public LocalDateTime getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(LocalDateTime dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }
}
