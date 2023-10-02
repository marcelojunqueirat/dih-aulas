package tech.devinhouse.clamedv2.aula04.listadetarefas.util;

import tech.devinhouse.clamedv2.aula04.listadetarefas.model.Tarefa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class GeradorDeArquivo {

    public static void gerar(String nomeArquivo, List<Tarefa> lista) throws IOException {
        Path path = Paths.get(nomeArquivo);
        Files.deleteIfExists(path);
        Files.createFile(path);
        for(Tarefa tarefa: lista) {
            String linha = tarefa.toString() + "\n";  // quebra de linha
            Files.writeString(path, linha, StandardOpenOption.APPEND);
        }

    }

}
