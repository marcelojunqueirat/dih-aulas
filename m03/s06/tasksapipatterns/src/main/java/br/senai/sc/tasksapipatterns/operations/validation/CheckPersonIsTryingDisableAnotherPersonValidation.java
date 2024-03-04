package br.senai.sc.tasksapipatterns.operations.validation;

import br.senai.sc.tasksapipatterns.exceptions.InvalidPermissionException;
import br.senai.sc.tasksapipatterns.model.Person;
import br.senai.sc.tasksapipatterns.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;

public class CheckPersonIsTryingDisableAnotherPersonValidation implements Validation {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckPersonIsTryingDisableAnotherPersonValidation.class);

    private final PersonService personService;
    private final UserDetails userInSession;
    private final String userIdentifier;

    public CheckPersonIsTryingDisableAnotherPersonValidation(PersonService personService, UserDetails userInSession, String userIdentifier) {
        this.personService = personService;
        this.userInSession = userInSession;
        this.userIdentifier = userIdentifier;
    }

    @Override
    public void execute() throws Exception {
        LOGGER.info("Checking that the user is not trying to disable another user...");
        Person person = this.personService.getPersonByGUID(this.userIdentifier);
        if (!person.getEmail().equals(this.userInSession.getUsername())) {
            throw new InvalidPermissionException("The user cannot disable another user, only themselves");
        }
    }

    @Override
    public void setNextValidation(Validation validation) {
        LOGGER.warn("Method not allowed");
    }
}
