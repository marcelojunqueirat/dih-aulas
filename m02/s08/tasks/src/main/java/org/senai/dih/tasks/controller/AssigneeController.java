package org.senai.dih.tasks.controller;

import jakarta.validation.Valid;
import org.senai.dih.tasks.model.transport.AssigneeDTO;
import org.senai.dih.tasks.model.transport.create.CreateAssigneeDTO;
import org.senai.dih.tasks.service.AssigneeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assignees")
public class AssigneeController {

    private final AssigneeService assigneeService;

    public AssigneeController(AssigneeService assigneeService) {
        this.assigneeService = assigneeService;
    }

    @PostMapping
    public ResponseEntity<AssigneeDTO> create(@RequestBody @Valid CreateAssigneeDTO body) {
        AssigneeDTO response = this.assigneeService.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<AssigneeDTO>> list(@PageableDefault(size = 10, sort = "name") Pageable pageable) {
        Page<AssigneeDTO> response = this.assigneeService.list(pageable);
        if (response.hasContent()) {
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssigneeDTO> update(@PathVariable("id") Long id, @RequestBody @Valid CreateAssigneeDTO body) {
        AssigneeDTO response = this.assigneeService.update(id, body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.assigneeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssigneeDTO> get(@PathVariable("id") Long id) {
        AssigneeDTO response = this.assigneeService.get(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }
}
