package tech.devinhouse.personagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.devinhouse.personagem.model.Personagem;
import tech.devinhouse.personagem.model.Referencia;
import tech.devinhouse.personagem.repository.PersonagemRepository;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class Aplicacao {

    @Autowired
    private PersonagemRepository personagemRepo;

    public void executar() {
        Personagem batman = new Personagem("Batman",
                Referencia.FILME, LocalDateTime.now());
        Personagem johnSnow = new Personagem("John Snow",
                Referencia.SERIADO, LocalDateTime.now());
        personagemRepo.save(batman);
        personagemRepo.save(johnSnow);
        List<Personagem> personagens = personagemRepo.findAll();
        for(Personagem personagem : personagens) {
            System.out.println(personagem);
        }
    }

}
