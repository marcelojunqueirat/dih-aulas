package br.senai.sc.tasksapipatterns.operations.validation;

import br.senai.sc.tasksapipatterns.exceptions.InvalidPermissionException;
import br.senai.sc.tasksapipatterns.model.Assignment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;

public class CheckPersonIsTryingToDeleteAnotherPersonAssignmentValidation implements Validation {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckPersonIsTryingToDeleteAnotherPersonAssignmentValidation.class);

    private final Assignment assignment;
    private final UserDetails userInSession;

    public CheckPersonIsTryingToDeleteAnotherPersonAssignmentValidation(Assignment assignment, UserDetails userInSession) {
        this.assignment = assignment;
        this.userInSession = userInSession;
    }

    @Override
    public void execute() throws Exception {
        LOGGER.info("Checking if person is trying to delete another person assignment...");
        if (!this.userInSession.getUsername().equals(this.assignment.getPerson().getEmail())) {
            throw new InvalidPermissionException("User can only delete their own assignment");
        }
    }

    @Override
    public void setNextValidation(Validation validation) {
        LOGGER.warn("Method not implemented");
    }
}
