package com.example.aula1.controller;

import com.example.aula1.dataprovider.Task;
import com.example.aula1.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getTasks(){

        return ResponseEntity.ok(taskService.getTask());
    }

    @PostMapping
    public ResponseEntity<Task> saveTask(@RequestBody Task task){

        return ResponseEntity.ok(taskService.saveTask(task));
    }


}
