package tech.devinhouse.personagem.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "PERSONAGENS")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Referencia referencia;

    private LocalDateTime dataCriacao;


    public Personagem() {   }

    public Personagem(Integer id, String nome, Referencia referencia, LocalDateTime dataCriacao) {
        this.id = id;
        this.nome = nome;
        this.referencia = referencia;
        this.dataCriacao = dataCriacao;
    }

    public Personagem(String nome, Referencia referencia, LocalDateTime dataCriacao) {
        this(null, nome, referencia, dataCriacao);
    }


    @Override
    public String toString() {
        return "Personagem{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", referencia=" + referencia +
                ", dataCriacao=" + dataCriacao +
                '}';
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

    public Referencia getReferencia() {
        return referencia;
    }

    public void setReferencia(Referencia referencia) {
        this.referencia = referencia;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
