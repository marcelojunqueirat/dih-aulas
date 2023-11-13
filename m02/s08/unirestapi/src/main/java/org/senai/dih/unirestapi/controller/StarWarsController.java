package org.senai.dih.unirestapi.controller;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.senai.dih.unirestapi.model.PeopleDTO;
import org.senai.dih.unirestapi.service.StarWarsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/star-wars")
public class StarWarsController {

    private final StarWarsService starWarsService;

    public StarWarsController(StarWarsService starWarsService) {
        this.starWarsService = starWarsService;
    }

    @GetMapping("/characters/{id}")
    public ResponseEntity<PeopleDTO> getPeopleById(@PathVariable("id") Integer id) throws UnirestException {
        PeopleDTO response = this.starWarsService.getPeopleById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/characters")
    public ResponseEntity<String> getPeople() throws UnirestException {
        String response = this.starWarsService.getPeople();
        return ResponseEntity.ok(response);
    }
}
