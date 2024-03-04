package br.senai.sc.tasksapipatterns.operations.notification.person;

import br.senai.sc.tasksapipatterns.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailNotificationOnDisablePersonObserver implements DisablePersonObserver {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmailNotificationOnDisablePersonObserver.class);

    @Override
    public void onDisablePerson(Person person) {
        LOGGER.info("Notification for {}: Attention, user! Your account has been disabled", person.getEmail());
    }
}
