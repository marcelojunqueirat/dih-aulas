package br.senai.sc.tasksapipatterns.exceptions;

public class PersonIsAlreadyDisabledException extends Exception {

    public PersonIsAlreadyDisabledException(String resource) {
        super("This user is already disabled: " + resource);
    }
}
