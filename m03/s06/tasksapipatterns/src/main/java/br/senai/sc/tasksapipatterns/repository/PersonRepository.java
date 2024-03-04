package br.senai.sc.tasksapipatterns.repository;

import br.senai.sc.tasksapipatterns.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByEmail(String email);
    Optional<Person> findByEmailAndEnabledTrue(String email);
    Optional<Person> findByGuidAndEnabledTrue(String guid);
    Optional<Person> findByGuid(String guid);
}
