package com.example.aula1.service;

import com.example.aula1.dataprovider.Task;
import com.example.aula1.dataprovider.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> getTask() {
        return taskRepository.findAll();
    }
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

}
