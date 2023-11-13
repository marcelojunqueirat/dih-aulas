package org.senai.dih.tasks.controller;

import jakarta.validation.Valid;
import org.senai.dih.tasks.model.transport.TaskDTO;
import org.senai.dih.tasks.model.transport.create.CreateTaskDTO;
import org.senai.dih.tasks.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping
    public ResponseEntity<TaskDTO> create(@RequestBody @Valid CreateTaskDTO body) {
        TaskDTO response = this.taskService.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<TaskDTO>> list(@PageableDefault(size = 10, sort = "title") Pageable pageable) {
        Page<TaskDTO> response = this.taskService.list(pageable);
        if (response.hasContent()) {
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> update(@PathVariable("id") Long id, @RequestBody @Valid CreateTaskDTO body) {
        TaskDTO response = this.taskService.update(id, body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> get(@PathVariable("id") Long id) {
        TaskDTO response = this.taskService.get(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }
}
