package br.senai.sc.tasksapipatterns.exceptions;

public class InvalidPermissionException extends Exception {

    public InvalidPermissionException(String message) {
        super(message);
    }
}
