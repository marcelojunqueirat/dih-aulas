package br.senai.sc.tasksapipatterns.operations.notification;

import br.senai.sc.tasksapipatterns.model.Person;

public interface Notification {

    void send(Person person, String content);
}
