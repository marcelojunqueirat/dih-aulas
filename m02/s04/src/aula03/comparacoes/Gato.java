package aula03.comparacoes;

import java.util.Objects;

public class Gato extends Object {

    private String nome;

    private String corDoPelo;


    @Override  // versao do equals da IDE baseada no criterio que eu escolhi
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Gato gato = (Gato) o;  // cast
        return Objects.equals(nome, gato.nome); // mesma coisa que this.nome.equals(gato.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }


    //    @Override   // sobrescrita - versao implementada 'na mão'
//    public boolean equals(Object obj) {
//        // Regra: no meu sistema, um gato só é igual ao outro,
//        // se tiver o mesmo nome
//        boolean resultado = false;
//        if (obj instanceof Gato) {
//            Gato outro = (Gato) obj;  // casting
//            resultado = this.nome.equals(outro.nome);
//        }
//        return resultado;
//    }

    public Gato(String nome, String corDoPelo) {
        this.nome = nome;
        this.corDoPelo = corDoPelo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCorDoPelo() {
        return corDoPelo;
    }

    public void setCorDoPelo(String corDoPelo) {
        this.corDoPelo = corDoPelo;
    }
}
