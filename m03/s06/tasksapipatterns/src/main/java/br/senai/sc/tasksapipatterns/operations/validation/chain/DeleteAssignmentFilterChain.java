package br.senai.sc.tasksapipatterns.operations.validation.chain;

import br.senai.sc.tasksapipatterns.model.Assignment;
import br.senai.sc.tasksapipatterns.operations.validation.CheckAssignmentIsAlreadyDeletedValidation;
import br.senai.sc.tasksapipatterns.operations.validation.CheckPersonIsTryingToDeleteAnotherPersonAssignmentValidation;
import br.senai.sc.tasksapipatterns.operations.validation.Validation;
import org.springframework.security.core.userdetails.UserDetails;

public class DeleteAssignmentFilterChain {

    private final Assignment assignment;
    private final UserDetails userInSession;

    public DeleteAssignmentFilterChain(Assignment assignment, UserDetails userInSession) {
        this.assignment = assignment;
        this.userInSession = userInSession;
    }

    public Validation buildChain() {

        CheckAssignmentIsAlreadyDeletedValidation checkIsDeleted =
                new CheckAssignmentIsAlreadyDeletedValidation(assignment);

        CheckPersonIsTryingToDeleteAnotherPersonAssignmentValidation checkUserHasPermission =
                new CheckPersonIsTryingToDeleteAnotherPersonAssignmentValidation(assignment, userInSession);

        checkIsDeleted.setNextValidation(checkUserHasPermission);
        return checkIsDeleted;
    }
}
