package br.senai.sc.apispringclient.controller;

import br.senai.sc.apispringclient.client.http.TasksClientService;
import br.senai.sc.apispringclient.exception.HttpRequestException;
import br.senai.sc.apispringclient.model.transport.PersonDTO;
import br.senai.sc.apispringclient.model.transport.operations.CreatePersonDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final TasksClientService clientService;

    public PersonController(TasksClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getByGuid(@PathVariable("id") String id)
            throws HttpRequestException, URISyntaxException, IOException, InterruptedException {
        PersonDTO response = this.clientService.findPersonByGuid(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<PersonDTO> create(@Valid @RequestBody CreatePersonDTO body)
            throws HttpRequestException, URISyntaxException, IOException, InterruptedException {
        PersonDTO response = this.clientService.createPerson(body);
        return ResponseEntity.ok(response);
    }
}
