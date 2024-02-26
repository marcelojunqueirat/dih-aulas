package br.senai.sc.tasksapitests.controller;

import br.senai.sc.tasksapitests.exceptions.UserNotFoundException;
import br.senai.sc.tasksapitests.model.transport.PersonDTO;
import br.senai.sc.tasksapitests.model.transport.operations.create.CreatePersonForm;
import br.senai.sc.tasksapitests.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> get(@PathVariable("id") String guid) throws UserNotFoundException {
        PersonDTO response = this.personService.getByGuid(guid);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<PersonDTO> create(@RequestBody @Valid CreatePersonForm form, UriComponentsBuilder uriComponentsBuilder) {
        PersonDTO response = this.personService.create(form);
        return ResponseEntity.created(uriComponentsBuilder.path("/person/{id}").buildAndExpand(response.guid()).toUri()).body(response);
    }
}
