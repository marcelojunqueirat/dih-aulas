package br.senai.sc.tasksapipatterns.operations.validation;

import br.senai.sc.tasksapipatterns.exceptions.AssignmentNotFoundException;
import br.senai.sc.tasksapipatterns.model.Assignment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckAssignmentIsAlreadyDeletedValidation implements Validation {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckAssignmentIsAlreadyDeletedValidation.class);

    private Validation nextValidation;
    private final Assignment assignment;

    public CheckAssignmentIsAlreadyDeletedValidation(Assignment assignment) {
        this.assignment = assignment;
    }

    @Override
    public void execute() throws Exception {
        LOGGER.info("Checking if assignment is already deleted before delete it...");
        if (this.assignment.isDeleted()) {
            throw new AssignmentNotFoundException(this.assignment.getGuid());
        }

        this.nextValidation.execute();
    }

    @Override
    public void setNextValidation(Validation validation) {
        this.nextValidation = validation;
    }
}
