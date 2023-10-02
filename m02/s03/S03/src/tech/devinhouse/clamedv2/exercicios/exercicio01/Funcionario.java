package tech.devinhouse.clamedv2.exercicios.exercicio01;

public class Funcionario {

    private Long cpf;

    private String nomeCompleto;

    private Float salario;


    public Funcionario() { }

    public Funcionario(Long cpf, String nomeCompleto, Float salario) {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.salario = salario;
    }


    public void promover(Float percentual) {
        this.salario *= (1 + (percentual/100));
//        this.salario = (1 + (percentual/100)) * salario;
    }


    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

}
