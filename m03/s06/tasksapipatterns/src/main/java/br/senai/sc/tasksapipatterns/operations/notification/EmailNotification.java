package br.senai.sc.tasksapipatterns.operations.notification;

import br.senai.sc.tasksapipatterns.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailNotification implements Notification {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailNotification.class);

    @Override
    public void send(Person person, String content) {
        LOGGER.info("Notification for {}: {}", person.getEmail(), content);
    }
}
