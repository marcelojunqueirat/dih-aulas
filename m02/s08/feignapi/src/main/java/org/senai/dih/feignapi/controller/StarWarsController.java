package org.senai.dih.feignapi.controller;

import org.senai.dih.feignapi.clients.StarWarsClient;
import org.senai.dih.feignapi.model.PeopleDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/star-wars")
public class StarWarsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StarWarsController.class);
    private final StarWarsClient starWarsClient;

    public StarWarsController(StarWarsClient starWarsClient) {
        this.starWarsClient = starWarsClient;
    }

    @GetMapping("/characters/{id}")
    public ResponseEntity<PeopleDTO> getById(@PathVariable("id") Integer id) {
        LOGGER.info("Buscando na API Star Wars via OpenFeign...");
        return this.starWarsClient.getPeople(id);
    }
}
