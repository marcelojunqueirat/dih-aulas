package br.senai.sc.tasksapipatterns.model.transport;

import br.senai.sc.tasksapipatterns.model.Person;

public record PersonDTO(String guid, String name, String email) {

    public PersonDTO(Person person) {
        this(person.getGuid(), person.getName(), person.getEmail());
    }
}
