package br.senai.sc.tasksapipatterns.controller;

import br.senai.sc.tasksapipatterns.exceptions.InvalidNotificationTypeException;
import br.senai.sc.tasksapipatterns.exceptions.PersonNotFoundException;
import br.senai.sc.tasksapipatterns.model.operations.CreatePersonForm;
import br.senai.sc.tasksapipatterns.model.transport.PersonDTO;
import br.senai.sc.tasksapipatterns.model.transport.TaskDTO;
import br.senai.sc.tasksapipatterns.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonDTO> create(@RequestBody @Valid CreatePersonForm form,
                                            UriComponentsBuilder uriComponentsBuilder) throws InvalidNotificationTypeException {
        PersonDTO response = this.personService.create(form);

        return ResponseEntity.created(uriComponentsBuilder
                .path("/person/{id}")
                .buildAndExpand(response.guid()).toUri()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskDTO> disableUser(@PathVariable("id") String id,
                                               @AuthenticationPrincipal UserDetails userInSession) throws PersonNotFoundException {
        TaskDTO response = this.personService.disableUser(id, userInSession);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getByGUID(@PathVariable String id) throws PersonNotFoundException {
        PersonDTO response = this.personService.getByGUID(id);
        return ResponseEntity.ok(response);
    }
}
