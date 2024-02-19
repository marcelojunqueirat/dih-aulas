package br.senai.sc.apispring.repository;

import br.senai.sc.apispring.model.Task;
import br.senai.sc.apispring.model.composite.TaskComposite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, TaskComposite> {

    Optional<Task> findByTaskCompositeGuid(String guid);
}
