package br.senai.sc.tasksapipatterns.repository;

import br.senai.sc.tasksapipatterns.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
