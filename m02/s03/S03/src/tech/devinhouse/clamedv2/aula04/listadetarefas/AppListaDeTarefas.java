package tech.devinhouse.clamedv2.aula04.listadetarefas;

import tech.devinhouse.clamedv2.aula04.listadetarefas.cli.TarefaCLI;
import tech.devinhouse.clamedv2.aula04.listadetarefas.model.Operacao;
import tech.devinhouse.clamedv2.aula04.listadetarefas.model.Tarefa;
import tech.devinhouse.clamedv2.aula04.listadetarefas.repository.TarefaRepository;
import tech.devinhouse.clamedv2.aula04.listadetarefas.util.GeradorDeArquivo;

import java.io.IOException;
import java.util.List;

import static tech.devinhouse.clamedv2.aula04.listadetarefas.model.Operacao.SAIR;

/**
 * Classe que representa a aplicacao de
 * Lista de Tarefas
 */
public class AppListaDeTarefas {

    private TarefaCLI cli = new TarefaCLI();
    private TarefaRepository repo = new TarefaRepository();

    public void executar() throws IOException {
        Operacao operacao;
        do {
            cli.exibirMenu();
            operacao = cli.obterOperacao();
            processar(operacao);
        } while (operacao != SAIR);
        cli.finalizar();
    }

    private void processar(Operacao operacao) throws IOException {
        if (operacao == null) {
            cli.exibirMensagemErro("Opcao Inválida!");
            cli.aguardar();
        } else if (operacao == Operacao.ADICIONAR) {
            Tarefa tarefa = cli.obterDadosDaTarefa();
            repo.inserir(tarefa);
            cli.exibir("Tarefa inserida com sucesso!");
        } else if (operacao == Operacao.LISTAR) {
            List<Tarefa> tarefas = repo.obter();
            for (Tarefa tarefa: tarefas) {
                cli.exibir(tarefa);
            }
            cli.aguardar();
        } else if (operacao == Operacao.LISTAR_POR_ID) {
            int id = cli.obterIdDaTarefa();
            Tarefa tarefa = repo.obterPorId(id);
            cli.exibir(tarefa);
            cli.aguardar();
        } else if (operacao == Operacao.MARCAR_CONCLUIDO) {
            int id = cli.obterIdDaTarefa();
            repo.marcarComoConcluida(id);
            cli.exibir("Tarefa indicada como concluída!");
            cli.aguardar();
        } else if (operacao == Operacao.EXPORTAR) {
            List<Tarefa> tarefas = repo.obter();
            GeradorDeArquivo.gerar("Tarefas.txt", tarefas);
            cli.exibir("Arquivo gerado!");
            cli.aguardar();
        }
    }

}
