package br.senai.sc.tasksapipatterns.operations.notification;

import br.senai.sc.tasksapipatterns.exceptions.InvalidNotificationTypeException;
import br.senai.sc.tasksapipatterns.model.Person;
import br.senai.sc.tasksapipatterns.operations.notification.create.NotificationFactory;

/**
 * Uso do Template Method para encapsular o código repetitivo de fábrica
 * para notificações
 */

public abstract class NotificationTemplateMethod {

    protected void notify(Person person, String content) throws InvalidNotificationTypeException {
        NotificationFactory
                .createNotification(person.getNotificationType())
                .send(person, content);
    }
}
