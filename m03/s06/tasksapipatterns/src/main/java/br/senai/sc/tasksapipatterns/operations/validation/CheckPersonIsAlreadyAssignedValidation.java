package br.senai.sc.tasksapipatterns.operations.validation;

import br.senai.sc.tasksapipatterns.exceptions.PersonAlreadyAssignedOnAssignmentException;
import br.senai.sc.tasksapipatterns.model.Assignment;
import br.senai.sc.tasksapipatterns.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckPersonIsAlreadyAssignedValidation implements Validation {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckPersonIsAlreadyAssignedValidation.class);
    private final Assignment assignment;
    private final Person assignee;

    public CheckPersonIsAlreadyAssignedValidation(Assignment assignment, Person assignee) {
        this.assignment = assignment;
        this.assignee = assignee;
    }

    @Override
    public void execute() throws Exception {
        if (!assignment.getAssignees().isEmpty() && assignment.getAssignees().contains(assignee)) {
            throw new PersonAlreadyAssignedOnAssignmentException("This user is already assigned on this task");
        }
    }

    @Override
    public void setNextValidation(Validation validation) {
        LOGGER.warn("Method not implemented");
    }
}
