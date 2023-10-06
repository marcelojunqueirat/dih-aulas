package aula03.comparacoes;

import java.time.LocalDate;
import java.util.Objects;

public class Funcionario implements Comparable<Funcionario> {

    private Integer matricula;

    private String nome;

    private LocalDate dataAdmissao;


    public Funcionario() {}
    public Funcionario(Integer matricula, String nome, LocalDate dataAdmissao) {
        this.matricula = matricula;
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
    }

    public Funcionario(Integer matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario outro = (Funcionario) o; // cast
        return Objects.equals(matricula, outro.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", dataAdmissao=" + dataAdmissao +
                '}';
    }

    @Override
    public int compareTo(Funcionario funcionario) {
        return this.matricula.compareTo(funcionario.getMatricula());
    }



    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
}
