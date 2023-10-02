package tech.devinhouse.clamedv2.aula04.listadetarefas.repository;

import tech.devinhouse.clamedv2.aula04.listadetarefas.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pela interação com fonte de dados
 */
public class TarefaRepository {

    private static int identificador = 0;


    private List<Tarefa> tarefas = new ArrayList<>(); // simulando BD

    public void inserir(Tarefa tarefa) {
        int novoId = ++identificador;
        tarefa.setId(novoId);
        tarefas.add(tarefa);
    }

    public List<Tarefa> obter() {
        return tarefas;
    }

    public Tarefa obterPorId(int id) {
        for(Tarefa tarefa: tarefas) {
            if (tarefa.getId() == id)
                return tarefa;
        }
        return null;
//        return tarefas.stream().filter(t -> t.getId() == id).findFirst().get();
    }

    public void marcarComoConcluida(int id) {
        for(Tarefa tarefa: tarefas) {
            if (tarefa.getId() == id)
                tarefa.setConcluida(true);
        }
    }
}
