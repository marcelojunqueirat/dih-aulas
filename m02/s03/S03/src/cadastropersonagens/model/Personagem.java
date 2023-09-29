package cadastropersonagens.model;

public class Personagem {
    private Integer id;
    private String nome;
    private String serie;

    public Personagem() {
    }

    public Personagem(String nome, String serie) {
        this.nome = nome;
        this.serie = serie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    @Override
    public String toString() {
        return "Personagem{" +
                "id= " + id +
                ", nome= '" + nome + '\'' +
                ", serie= '" + serie + '\'' +
                '}';
    }
}
