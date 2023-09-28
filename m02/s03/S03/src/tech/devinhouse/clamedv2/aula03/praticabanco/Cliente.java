package tech.devinhouse.clamedv2.aula03.praticabanco;

public class Cliente {

    private String nome;
    private Integer idade;
    private String profissao;

    public String obterNomeEmMaiusculo() {
        return this.nome.toUpperCase();
    }

    public String obterDadosFormatados() {
        return String.format("Nome = %s, Idade = %d", nome, idade);
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", profissao='" + profissao + '\'' +
                '}';
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

}
