package br.senai.sc.tasksapipatterns.exceptions;

public class PersonNotFoundException extends Exception {

    public PersonNotFoundException(String resource) {
        super("User not found: " + resource);
    }
}
