package br.senai.sc.apispringclient.controller;

import br.senai.sc.apispringclient.exception.HttpRequestException;
import br.senai.sc.apispringclient.model.transport.TaskDTO;
import br.senai.sc.apispringclient.model.transport.operations.CreateTaskDTO;
import br.senai.sc.apispringclient.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> findByGuid(@PathVariable("id") String id) throws HttpRequestException {
        TaskDTO response = this.taskService.getTaskByGuid(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<TaskDTO> create(@Valid @RequestBody CreateTaskDTO body)
            throws HttpRequestException {
        TaskDTO response = this.taskService.create(body);
        return ResponseEntity.ok(response);
    }
}
