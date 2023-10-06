package aula03.comparacoes;

import java.util.Comparator;

public class DataAdmissaoComparator implements Comparator<Funcionario> {

    @Override
    public int compare(Funcionario funcionario1, Funcionario funcionario2) {
        return funcionario1.getDataAdmissao().compareTo(funcionario2.getDataAdmissao());
    }

}
