package br.senai.sc.tasksapipatterns.exceptions;

public class AssignmentNotFoundException extends Exception {
    public AssignmentNotFoundException(String resource) {
        super("Assignment not found: " + resource);
    }
}
