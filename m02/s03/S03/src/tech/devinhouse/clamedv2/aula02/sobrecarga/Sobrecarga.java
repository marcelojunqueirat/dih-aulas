package tech.devinhouse.clamedv2.aula02.sobrecarga;

public class Sobrecarga {

    public String obterDadosFormatados(String valor) {
        return "Formatei " + valor;
    }

    // sobrecarga / overloading
    public String obterDadosFormatados(String valor, Integer tipo) {
        if (tipo == 1)
            return valor.toUpperCase();
        else
            return valor.toLowerCase();
    }

    // sobrecarga
    public String obterDadosFormatados() {
        return "vazio";
    }

    // sobrecarga
    public String obterDadosFormatados(Integer codigo) {
        return "Codigo = " + codigo;
    }

}
