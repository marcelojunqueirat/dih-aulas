package cadastropersonagens.repository;


import cadastropersonagens.model.Personagem;

import java.util.ArrayList;
import java.util.List;

public class PersonagemRepository {

    private static int id = 0;

    private List<Personagem> personagens = new ArrayList<>(); // simulando BD

    public void inserir(Personagem personagem) {
        int novoId = ++id;
        personagem.setId(novoId);
        personagens.add(personagem);
    }

    public List<Personagem> obter() {
        return personagens;
    }

    public void excluirPorId(int id) {
        personagens.removeIf(personagem -> personagem.getId() == id);
    }


}
