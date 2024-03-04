package br.senai.sc.tasksapipatterns.operations.validation.chain;

import br.senai.sc.tasksapipatterns.model.Assignment;
import br.senai.sc.tasksapipatterns.model.Person;
import br.senai.sc.tasksapipatterns.operations.validation.CheckAssignmentIsEnableForAssigneesValidation;
import br.senai.sc.tasksapipatterns.operations.validation.CheckPersonIsAlreadyAssignedValidation;
import br.senai.sc.tasksapipatterns.operations.validation.CheckPersonIsTryingSignHimselfValidation;
import br.senai.sc.tasksapipatterns.operations.validation.Validation;

public class ApplyAssigneeFilterChain {

    private final Assignment assignment;
    private final Person assignee;

    public ApplyAssigneeFilterChain(Assignment assignment, Person assignee) {
        this.assignment = assignment;
        this.assignee = assignee;
    }


    public Validation buildChain() {
        CheckAssignmentIsEnableForAssigneesValidation checkAssigneesEnabled =
                new CheckAssignmentIsEnableForAssigneesValidation(this.assignment);

        CheckPersonIsTryingSignHimselfValidation checkSignHimself =
                new CheckPersonIsTryingSignHimselfValidation(assignment, assignee);

        CheckPersonIsAlreadyAssignedValidation checkPersonAlreadyAssignee =
                new CheckPersonIsAlreadyAssignedValidation(assignment, assignee);

        checkAssigneesEnabled.setNextValidation(checkSignHimself);
        checkSignHimself.setNextValidation(checkPersonAlreadyAssignee);
        return checkAssigneesEnabled;
    }
}
