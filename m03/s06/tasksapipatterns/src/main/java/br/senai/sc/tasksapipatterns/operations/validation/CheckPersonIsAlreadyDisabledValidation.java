package br.senai.sc.tasksapipatterns.operations.validation;

import br.senai.sc.tasksapipatterns.exceptions.PersonIsAlreadyDisabledException;
import br.senai.sc.tasksapipatterns.model.Person;
import br.senai.sc.tasksapipatterns.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckPersonIsAlreadyDisabledValidation implements Validation {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckPersonIsAlreadyDisabledValidation.class);

    private Validation nextValidation;
    private final PersonService personService;
    private final String userIdentifier;

    public CheckPersonIsAlreadyDisabledValidation(PersonService personService, String userIdentifier) {
        this.personService = personService;
        this.userIdentifier = userIdentifier;
    }

    @Override
    public void execute() throws Exception {
        LOGGER.info("Checking if person is already disabled before disable it...");
        Person person = this.personService.getPersonByGUID(this.userIdentifier);
        if (!person.isEnabled()) {
            throw new PersonIsAlreadyDisabledException(this.userIdentifier);
        }

        this.nextValidation.execute();
    }

    @Override
    public void setNextValidation(Validation validation) {
        this.nextValidation = validation;
    }
}
