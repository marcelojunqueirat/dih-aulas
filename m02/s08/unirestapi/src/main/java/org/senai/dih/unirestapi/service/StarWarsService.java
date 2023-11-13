package org.senai.dih.unirestapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.senai.dih.unirestapi.model.PeopleDTO;
import org.springframework.stereotype.Service;

@Service
public class StarWarsService {

    public PeopleDTO getPeopleById(Integer id) throws UnirestException {
        this.configureMapper();
        Unirest.setTimeouts(0, 0); // 0 indica que não há limite de tempo
        HttpResponse<PeopleDTO> response = Unirest
                .get("https://swapi.dev/api/people/" + id).asObject(PeopleDTO.class);

        return response.getBody();
    }

    public String getPeople() throws UnirestException {
        Unirest.setTimeouts(0, 0); // 0 indica que não há limite de tempo
        return Unirest
                .get("https://swapi.dev/api/people").asString().getBody();
    }

//    Configura a classe que vai serializar e desserializar as informações.
    private void configureMapper() {
        Unirest.setObjectMapper(new ObjectMapper() {

            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();

            @Override
            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return mapper.readValue(value, valueType);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public String writeValue(Object value) {
                try {
                    return mapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
