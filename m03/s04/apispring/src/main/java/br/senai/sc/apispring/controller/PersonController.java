package br.senai.sc.apispring.controller;

import br.senai.sc.apispring.exceptions.PersonNotFoundException;
import br.senai.sc.apispring.model.transport.PersonDTO;
import br.senai.sc.apispring.model.transport.operations.CreatePersonDTO;
import br.senai.sc.apispring.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> findByGuid(@PathVariable("id") String guid) throws PersonNotFoundException {
        PersonDTO response = this.personService.findByGuid(guid);
        return ResponseEntity.ok(response);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDTO> create(@Valid @RequestBody CreatePersonDTO body) {
        PersonDTO response = this.personService.create(body);
        return ResponseEntity.created(URI.create(String.format("/person/%s", response.guid()))).body(response);
    }
}
