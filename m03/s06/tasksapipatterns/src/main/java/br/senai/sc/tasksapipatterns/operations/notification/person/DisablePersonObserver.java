package br.senai.sc.tasksapipatterns.operations.notification.person;

import br.senai.sc.tasksapipatterns.model.Person;

public interface DisablePersonObserver {

    void onDisablePerson(Person person);
}
