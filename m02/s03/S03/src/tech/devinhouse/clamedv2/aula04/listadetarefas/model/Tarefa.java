package tech.devinhouse.clamedv2.aula04.listadetarefas.model;

/**
 * Representa uma Tarefa
 */
public class Tarefa {

    private Integer id;
    private String texto;
    private boolean concluida;  // false

    public Tarefa() { }

    public Tarefa(String texto) {
        this.texto = texto;
    }


    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", texto='" + texto + '\'' +
                ", concluida=" + concluida +
                '}';
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}
