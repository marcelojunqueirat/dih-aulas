package com.example.aula1.dataprovider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findAllByFinalizada(boolean finalizada); //true -> tarefas finalizadas
                                                        //false -> tarefas em andamento
}
