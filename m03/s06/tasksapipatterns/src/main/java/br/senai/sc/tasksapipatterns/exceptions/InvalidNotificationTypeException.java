package br.senai.sc.tasksapipatterns.exceptions;

public class InvalidNotificationTypeException extends Exception {

    public InvalidNotificationTypeException(String message) {
        super(message);
    }
}
