package br.senai.sc.apispring.repository;

import br.senai.sc.apispring.model.Person;
import br.senai.sc.apispring.model.composite.PersonComposite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, PersonComposite> {

    // SELECT * FROM person WHERE guid = :guid;
    Optional<Person> findByGuid(String guid);

    Optional<Person> findByEmail(String email);
}
