package org.senai.dih.feignapi.clients;

import org.senai.dih.feignapi.model.PeopleDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "star-wars-client", url = "https://swapi.dev/api", path = "/people")
public interface StarWarsClient {

    @GetMapping("/{id}")
    public ResponseEntity<PeopleDTO> getPeople(@PathVariable("id") Integer id);
}
