package br.senai.sc.tasksapipatterns.service;

import br.senai.sc.tasksapipatterns.exceptions.InvalidNotificationTypeException;
import br.senai.sc.tasksapipatterns.exceptions.PersonNotFoundException;
import br.senai.sc.tasksapipatterns.model.Person;
import br.senai.sc.tasksapipatterns.model.enums.OperationTypeEnum;
import br.senai.sc.tasksapipatterns.model.operations.CreatePersonForm;
import br.senai.sc.tasksapipatterns.model.transport.PersonDTO;
import br.senai.sc.tasksapipatterns.model.transport.TaskDTO;
import br.senai.sc.tasksapipatterns.operations.person.CreatePersonFacade;
import br.senai.sc.tasksapipatterns.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    private final CreatePersonFacade createPersonFacade;
    private final TaskService taskService;
    private final PersonRepository personRepository;

    public PersonService(CreatePersonFacade createPersonFacade, @Lazy TaskService taskService, PersonRepository personRepository) {
        this.createPersonFacade = createPersonFacade;
        this.taskService = taskService;
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.personRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User by email not found: %s", username)));
    }

    public PersonDTO create(CreatePersonForm form) throws InvalidNotificationTypeException {
        LOGGER.info("Starting user creation...");
        return this.createPersonFacade.create(form);
    }

    public TaskDTO disableUser(String guid, UserDetails userInSession) throws PersonNotFoundException {
        return this.taskService.execute(OperationTypeEnum.DISABLED_USER, guid, userInSession);
    }

    public PersonDTO getByGUID(String guid) throws PersonNotFoundException {
        return new PersonDTO(this.getPersonByGUIDAndEnabledTrue(guid));
    }

    public Person getPersonByEmail(String email) throws PersonNotFoundException {
        return this.personRepository.findByEmailAndEnabledTrue(email)
                .orElseThrow(() -> new PersonNotFoundException(email));
    }

    public Person getPersonByGUID(String guid) throws PersonNotFoundException {
        return this.personRepository.findByGuid(guid)
                .orElseThrow(() -> new PersonNotFoundException(guid));
    }

    public Person getPersonByGUIDAndEnabledTrue(String guid) throws PersonNotFoundException {
        return this.personRepository.findByGuidAndEnabledTrue(guid)
                .orElseThrow(() -> new PersonNotFoundException(guid));
    }
}
