package br.senai.sc.tasksapipatterns.operations.validation;

import br.senai.sc.tasksapipatterns.exceptions.AssignmentIsNotEnableForAssigneesException;
import br.senai.sc.tasksapipatterns.model.Assignment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckAssignmentIsEnableForAssigneesValidation implements Validation {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckAssignmentIsEnableForAssigneesValidation.class);
    private Validation nextValidation;
    private final Assignment assignment;

    public CheckAssignmentIsEnableForAssigneesValidation(Assignment assignment) {
        this.assignment = assignment;
    }

    @Override
    public void execute() throws Exception {
        LOGGER.info("Checking if task is enabled for assignees...");
        if (!assignment.isEnableAssignees()) {
            throw new AssignmentIsNotEnableForAssigneesException("Task is not enable for assignees");
        }

        this.nextValidation.execute();
    }

    @Override
    public void setNextValidation(Validation validation) {
        this.nextValidation = validation;
    }
}
