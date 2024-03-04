package br.senai.sc.tasksapipatterns.repository;

import br.senai.sc.tasksapipatterns.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    Optional<Assignment> findByGuid(String guid);

    Optional<Assignment> findByGuidAndDeletedFalseAndPersonEmail(String guid, String email);
}
