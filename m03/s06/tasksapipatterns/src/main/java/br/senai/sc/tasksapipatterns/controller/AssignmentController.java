package br.senai.sc.tasksapipatterns.controller;

import br.senai.sc.tasksapipatterns.exceptions.AssignmentNotFoundException;
import br.senai.sc.tasksapipatterns.exceptions.PersonNotFoundException;
import br.senai.sc.tasksapipatterns.model.operations.ApplyAssigneeForm;
import br.senai.sc.tasksapipatterns.model.operations.CreateAssignmentForm;
import br.senai.sc.tasksapipatterns.model.transport.AssignmentDTO;
import br.senai.sc.tasksapipatterns.model.transport.TaskDTO;
import br.senai.sc.tasksapipatterns.service.AssignmentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssignmentDTO> getByGUID(@PathVariable("id") String id,
                                                   @AuthenticationPrincipal UserDetails userInSession)
            throws AssignmentNotFoundException {
        AssignmentDTO response = this.assignmentService.getByGUID(id, userInSession);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/report")
    public ResponseEntity<TaskDTO> generateReport(@RequestParam(name = "type", defaultValue = "PDF") String type,
                                                  @AuthenticationPrincipal UserDetails userInSession)
            throws PersonNotFoundException {
        TaskDTO response = this.assignmentService.generateReport(type, userInSession);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<TaskDTO> create(@RequestBody @Valid CreateAssignmentForm form,
                                          @AuthenticationPrincipal UserDetails userInSession,
                                          UriComponentsBuilder uriComponentsBuilder)
            throws PersonNotFoundException, JsonProcessingException {
        TaskDTO response = this.assignmentService.create(form, userInSession);

        return ResponseEntity.created(uriComponentsBuilder
                .path("/person/{id}")
                .buildAndExpand(response.getDetail()).toUri()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskDTO> delete(@PathVariable("id") String id,
                                          @AuthenticationPrincipal UserDetails userInSession) throws PersonNotFoundException {
        TaskDTO response = this.assignmentService.delete(id, userInSession);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/assignee")
    public ResponseEntity<TaskDTO> applyAssignee(@PathVariable("id") String id,
                                                 @RequestBody ApplyAssigneeForm form,
                                                 @AuthenticationPrincipal UserDetails userInSession)
            throws Exception {
        form.setAssignmentIdentifier(id);
        TaskDTO response = this.assignmentService.applyAssignee(form, userInSession);
        return ResponseEntity.created(URI.create(String.format("/assignment/%s", response.getDetail()))).body(response);
    }
}
