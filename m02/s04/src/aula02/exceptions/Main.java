package aula02.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        try {
            Integer numero = null;
            Integer resultado = numero / 5;
            System.out.println("Essa linha nao vai ser executada");
        } catch (NullPointerException e) {  // unchecked - nao preciso criar codigo para tratar
            e.printStackTrace(); // imprime o stack trace
            System.out.println("Ocorreu um NPE, tem variavel nao inicializada");
        } catch (IllegalArgumentException e) {
            System.out.println("Vc passou um argumento errado");
        } catch (Exception e) {
            System.out.println("Sou a excecao topo");
        }

        try {
            Integer resultado = 5 / 0;
            Files.createDirectories(Paths.get("/"));
            // multi-catch
        } catch (IOException | IllegalStateException e) {
            System.out.println("Deu pau");
        }

    }

}
