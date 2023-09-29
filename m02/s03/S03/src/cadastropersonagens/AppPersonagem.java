package cadastropersonagens;

import cadastropersonagens.model.Operacao;
import cadastropersonagens.model.Personagem;
import cadastropersonagens.repository.PersonagemRepository;
import cadastropersonagens.ui.Ui;
import cadastropersonagens.util.GeradorDeArquivo;

import java.io.IOException;
import java.util.List;

public class AppPersonagem {
    private Ui ui = new Ui();
    private PersonagemRepository repo = new PersonagemRepository();

    public void executar() throws IOException {
        Operacao operacao;
        do {
            ui.exibirMenu();
            operacao = ui.obterOperacao();
            this.processar(operacao);
        } while (operacao != Operacao.SAIR);
        ui.finalizar();
    }

    private void processar(Operacao operacao) throws IOException {
        if (operacao == null) {
            ui.exibirMensagemErro("Opcao Inválida!");
            ui.aguardar();
        } else if (operacao == Operacao.CADASTRAR) {
            Personagem personagem = ui.obterDadosDoPersonagem();
            repo.inserir(personagem);
            ui.exibir("Personagem inserido com sucesso!");
        } else if (operacao == Operacao.LISTAR) {
            List<Personagem> personagens = repo.obter();
            for (Personagem personagem : personagens) {
                ui.exibir(personagem);
            }
            ui.aguardar();
        } else if (operacao == Operacao.EXCLUIR) {
            int id = ui.obterIdDoPersonagem();
            repo.excluirPorId(id);
            ui.exibir("Personagem excluído com sucesso.");
            ui.aguardar();
        } else if (operacao == Operacao.EXPORTAR) {
            List<Personagem> personagens = repo.obter();
            GeradorDeArquivo.gerar("Personagens.txt", personagens);
            ui.exibir("Arquivo gerado!");
            ui.aguardar();
        }
    }
}
