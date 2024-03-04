package br.senai.sc.tasksapipatterns.exceptions;

public class InvalidReportTypeException extends Exception {
    public InvalidReportTypeException(String message) {
        super(message);
    }
}
