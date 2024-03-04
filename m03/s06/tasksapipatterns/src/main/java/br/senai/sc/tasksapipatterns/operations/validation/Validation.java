package br.senai.sc.tasksapipatterns.operations.validation;

public interface Validation {

    void execute() throws Exception;

    void setNextValidation(Validation validation);
}
