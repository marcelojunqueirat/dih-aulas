package br.senai.sc.tasksapipatterns.operations.validation;

import br.senai.sc.tasksapipatterns.exceptions.InvalidPermissionException;
import br.senai.sc.tasksapipatterns.model.Assignment;
import br.senai.sc.tasksapipatterns.model.Person;

public class CheckPersonIsTryingSignHimselfValidation implements Validation {

    private Validation nextValidation;
    private final Assignment assignment;
    private final Person assignee;

    public CheckPersonIsTryingSignHimselfValidation(Assignment assignment, Person assignee) {
        this.assignment = assignment;
        this.assignee = assignee;
    }

    @Override
    public void execute() throws Exception {
        if (this.assignment.getPerson().getGuid().equals(this.assignee.getGuid())) {
            throw new InvalidPermissionException("The user cannot be the owner and collaborator of the same assignment");
        }

        this.nextValidation.execute();
    }

    @Override
    public void setNextValidation(Validation validation) {
        this.nextValidation = validation;
    }
}
