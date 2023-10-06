package aula04.records;

import java.util.Objects;

public class Pessoa {

    private final Long cpf;

    private final String nome;


    public Pessoa(Long cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(cpf, pessoa.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return "Pessoa[" +
                "cpf=" + cpf +
                ", nome='" + nome + '\'' +
                ']';
    }


    public Long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

}
