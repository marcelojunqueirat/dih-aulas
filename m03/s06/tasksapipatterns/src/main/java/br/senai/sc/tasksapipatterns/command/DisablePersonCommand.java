package br.senai.sc.tasksapipatterns.command;

import br.senai.sc.tasksapipatterns.model.Person;
import br.senai.sc.tasksapipatterns.model.transport.TaskDTO;
import br.senai.sc.tasksapipatterns.operations.notification.person.DisablePersonObservable;
import br.senai.sc.tasksapipatterns.operations.notification.person.EmailNotificationOnDisablePersonObserver;
import br.senai.sc.tasksapipatterns.operations.notification.person.SmsNotificationOnDisablePersonObserver;
import br.senai.sc.tasksapipatterns.operations.validation.chain.DisablePersonFilterChain;
import br.senai.sc.tasksapipatterns.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/* Classe de comando para desabilitar a conta de um usuário */

@Lazy
@Component
public class DisablePersonCommand implements TaskCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(DisablePersonCommand.class);
    private final PersonService personService;
    private final DisablePersonObservable disablePersonObservable;

    public DisablePersonCommand(PersonService personService) {
        this.personService = personService;
        this.disablePersonObservable = new DisablePersonObservable();
    }

    @Override
    @Transactional
    public TaskDTO execute(TaskDTO taskDTO) throws Exception {
        LOGGER.info("Starting user deasctivation...");
        String userIdentifier = taskDTO.getMetadata();
        UserDetails userInSession = taskDTO.getUserInSession();

        this.executeValidations(userIdentifier, userInSession);
        Person person = this.personService.getPersonByGUID(userIdentifier);
        person.disable();

        this.notifyObservables(person);

        return taskDTO;
    }

    private void executeValidations(String userIdentifier, UserDetails userInSession) throws Exception {
        LOGGER.info("Executing validations...");
        DisablePersonFilterChain validations =
                new DisablePersonFilterChain(userIdentifier, userInSession, personService);
        validations.buildChain().execute();
    }

    /* Uso do padrão Observable para notificar os interessados */
    private void notifyObservables(Person person) {
        this.disablePersonObservable.add(new EmailNotificationOnDisablePersonObserver());
        this.disablePersonObservable.add(new SmsNotificationOnDisablePersonObserver());
        this.disablePersonObservable.notify(person);
    }
}
