package br.senai.sc.tasksapitests.repository;

import br.senai.sc.tasksapitests.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByEmail(String email);

    Optional<Person> findByGuid(String guid);
}
