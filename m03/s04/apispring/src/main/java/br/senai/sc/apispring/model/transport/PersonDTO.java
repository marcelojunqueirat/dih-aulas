package br.senai.sc.apispring.model.transport;

import br.senai.sc.apispring.model.Person;

public record PersonDTO(String guid,
                        String email,
                        String name,
                        ResidenceAddressDTO address) {

    public PersonDTO(Person person) {
        this(person.getGuid(), person.getEmail(), person.getName(), new ResidenceAddressDTO(person.getAddress()));
    }
}
