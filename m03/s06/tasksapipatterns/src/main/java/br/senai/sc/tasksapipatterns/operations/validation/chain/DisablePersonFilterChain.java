package br.senai.sc.tasksapipatterns.operations.validation.chain;

import br.senai.sc.tasksapipatterns.operations.validation.CheckPersonIsAlreadyDisabledValidation;
import br.senai.sc.tasksapipatterns.operations.validation.CheckPersonIsTryingDisableAnotherPersonValidation;
import br.senai.sc.tasksapipatterns.operations.validation.Validation;
import br.senai.sc.tasksapipatterns.service.PersonService;
import org.springframework.security.core.userdetails.UserDetails;

public class DisablePersonFilterChain {

    private final String userIdentifier;
    private final UserDetails userInSession;
    private final PersonService personService;


    public DisablePersonFilterChain(String userIdentifier,
                                     UserDetails userInSession,
                                     PersonService personService) {
        this.userIdentifier = userIdentifier;
        this.userInSession = userInSession;
        this.personService = personService;
    }

    public Validation buildChain() {
        CheckPersonIsAlreadyDisabledValidation checkPersonIsAlreadyDisabledValidation =
                new CheckPersonIsAlreadyDisabledValidation(this.personService, this.userIdentifier);

        CheckPersonIsTryingDisableAnotherPersonValidation checkPersonIsTryingDisableAnotherPersonValidation =
                new CheckPersonIsTryingDisableAnotherPersonValidation(this.personService, this.userInSession, this.userIdentifier);

        checkPersonIsAlreadyDisabledValidation.setNextValidation(checkPersonIsTryingDisableAnotherPersonValidation);
        return checkPersonIsAlreadyDisabledValidation;
    }
}
