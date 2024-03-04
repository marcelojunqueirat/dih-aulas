package br.senai.sc.tasksapipatterns.exceptions;

public class PersonAlreadyAssignedOnAssignmentException extends Exception {

    public PersonAlreadyAssignedOnAssignmentException(String message) {
        super(message);
    }
}
