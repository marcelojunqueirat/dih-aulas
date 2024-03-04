package br.senai.sc.tasksapipatterns.operations.notification.person;

import br.senai.sc.tasksapipatterns.model.Person;

import java.util.ArrayList;
import java.util.List;

public class DisablePersonObservable {

    private final List<DisablePersonObserver> observers = new ArrayList<>();

    public void add(DisablePersonObserver observer) {
        this.observers.add(observer);
    }

    public void remove(DisablePersonObserver observer) {
        this.observers.remove(observer);
    }

    public void notify(Person person) {
        this.observers.forEach(observer -> observer.onDisablePerson(person));
    }
}
