package cadastropersonagens.util;

import cadastropersonagens.model.Personagem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class GeradorDeArquivo {
    public static void gerar(String nomeArquivo, List<Personagem> lista) throws IOException {
        Path path = Paths.get(nomeArquivo);
        Files.deleteIfExists(path);
        Files.createFile(path);
        for (Personagem personagem : lista) {
            String linha = personagem.toString() + "\n";  // quebra de linha
            Files.writeString(path, linha, StandardOpenOption.APPEND);
        }

    }
}
