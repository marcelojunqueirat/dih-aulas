package tech.devinhouse.personagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.personagem.model.Personagem;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Integer> {
}
