package br.senai.sc.apispring.controller;

import br.senai.sc.apispring.exceptions.PersonNotFoundException;
import br.senai.sc.apispring.exceptions.TaskNotFoundException;
import br.senai.sc.apispring.model.transport.TaskDTO;
import br.senai.sc.apispring.model.transport.operations.ApplyAssigneeDTO;
import br.senai.sc.apispring.model.transport.operations.CreateTaskDTO;
import br.senai.sc.apispring.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> create(@AuthenticationPrincipal UserDetails userInSession,
                                          @Valid @RequestBody CreateTaskDTO body,
                                          UriComponentsBuilder uriComponentsBuilder) throws PersonNotFoundException {
        TaskDTO response = this.taskService.create(body, userInSession);
        return ResponseEntity.created(uriComponentsBuilder.path("/task/{id}").buildAndExpand(response.guid()).toUri()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> findByGuid(@PathVariable("id") String id) throws TaskNotFoundException {
        TaskDTO response = this.taskService.findByGuid(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/assignee")
    public ResponseEntity<TaskDTO> applyAssignee(@PathVariable("id") String id,
                                                 @Valid @RequestBody ApplyAssigneeDTO body)
            throws TaskNotFoundException, PersonNotFoundException {
        TaskDTO response = this.taskService.applyAssignee(id, body);
        return ResponseEntity.ok(response);
    }
}
