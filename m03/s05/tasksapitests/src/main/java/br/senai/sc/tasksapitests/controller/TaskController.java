package br.senai.sc.tasksapitests.controller;

import br.senai.sc.tasksapitests.exceptions.TaskNotFoundException;
import br.senai.sc.tasksapitests.exceptions.UserNotFoundException;
import br.senai.sc.tasksapitests.model.transport.TaskDTO;
import br.senai.sc.tasksapitests.model.transport.operations.create.CreateTaskForm;
import br.senai.sc.tasksapitests.model.transport.operations.update.ApplyAssigneeForm;
import br.senai.sc.tasksapitests.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Set;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<Set<TaskDTO>> list() {
        Set<TaskDTO> response = this.taskService.list();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<TaskDTO> create(@AuthenticationPrincipal UserDetails userInSession,
                                          @Valid @RequestBody CreateTaskForm form) throws UserNotFoundException {
        TaskDTO response = this.taskService.create(form, userInSession);
        return ResponseEntity.created(URI.create(String.format("/task/%s", response.guid()))).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) throws TaskNotFoundException {
        this.taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/assignee")
    public ResponseEntity<TaskDTO> applyAssignee(@PathVariable("id") String id, @RequestBody ApplyAssigneeForm form)
            throws UserNotFoundException, TaskNotFoundException {
        TaskDTO response = this.taskService.applyAssignee(id, form);
        return ResponseEntity.created(URI.create(String.format("/task/%s", response.guid()))).body(response);
    }
}
