package tech.devinhouse.clamedv2.aula03.arquivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ManipuladorArquivos {

    public static void main(String[] args) throws IOException {

        // referencia arquivos
        Path path = Paths.get("arquivo.txt");
        Path dir = Paths.get("diretorio");
        Path path2 = dir.resolve("arquivo2.txt");
//        Paths.get("diretorio", "arquivo2.txt");

        // cria se nao existir
        if (Files.notExists(path)) {
            Files.createFile(path);
        }
        if (Files.notExists(path2)) {
            Files.createDirectory(dir);
            Files.createFile(path2);
        }

        // grava dados nos arquivos
        List<String> nomesStarWars = List.of("Luke Skywalker", "Obi-Wan Kenobi", "Han Solo", "Darth Vader");
        for(String nome: nomesStarWars) {
            nome = nome + "\n";  // quebra de linha
            Files.writeString(path, nome, StandardOpenOption.APPEND);
        }
        List<String> nomesStarTrek = List.of("James Kirk", "Spock", "Uhura", "Leonard McCoy", "Montgomery Scott");
        for(String nome: nomesStarTrek) {
            nome = nome + "\n";  // quebra de linha
            Files.writeString(path2, nome, StandardOpenOption.APPEND);
        }

        // lendo dados
        List<String> nomes1 = Files.readAllLines(path);
        nomes1.forEach(System.out::println);
        List<String> nomes2 = Files.readAllLines(path2);
        nomes2.forEach(System.out::println);
    }

}
