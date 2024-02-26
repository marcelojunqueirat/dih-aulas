package br.senai.sc.tasksapitests.exceptions;

public class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String message) {
        super(message);
    }
}
