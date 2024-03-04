package br.senai.sc.tasksapipatterns.operations.notification.create;

import br.senai.sc.tasksapipatterns.exceptions.InvalidNotificationTypeException;
import br.senai.sc.tasksapipatterns.model.enums.NotificationTypeEnum;
import br.senai.sc.tasksapipatterns.operations.notification.EmailNotification;
import br.senai.sc.tasksapipatterns.operations.notification.Notification;
import br.senai.sc.tasksapipatterns.operations.notification.SmsNotification;

public class NotificationFactory {

    private NotificationFactory() {

    }

    /**
     * Uso do padrão Factory Method
     */

    public static Notification createNotification(NotificationTypeEnum type)
            throws InvalidNotificationTypeException {

        return switch (type) {
            case EMAIL -> new EmailNotification();
            case SMS -> new SmsNotification();
            default -> throw new InvalidNotificationTypeException("Type is not valid: " + type);
        };
    }
}
