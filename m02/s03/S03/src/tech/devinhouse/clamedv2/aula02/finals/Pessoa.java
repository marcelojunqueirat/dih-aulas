package tech.devinhouse.clamedv2.aula02.finals;

public class Pessoa {

    private final String nome;  // obrigatoria

    private String nomeSocial;  // opcional

    private final Long cpf;

    private final String corPreferida;


    public Pessoa(String nome, Long cpf, String corPreferida) {
        this(nome, null, cpf, corPreferida);
    }

    public Pessoa(String nome, String nomeSocial, Long cpf, String corPreferida) {
        this.nome = nome;
        this.nomeSocial = nomeSocial;
        this.cpf = cpf;
        this.corPreferida = corPreferida;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", corPreferida='" + corPreferida + '\'' +
                '}';
    }


    // impede sobrescrita deste metodo
    public final void chamar() {
        System.out.println("Alowwwwww");
    }


    public String getNome() {
        return nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getCorPreferida() {
        return corPreferida;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }
}
