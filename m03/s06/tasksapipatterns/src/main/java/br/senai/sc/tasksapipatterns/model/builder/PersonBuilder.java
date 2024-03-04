package br.senai.sc.tasksapipatterns.model.builder;


/* Builder Pattern: Usamos para montagem de objetos complexos, como por
 * exemplo quando queremos evitar várias sobrecargas de construtores,
 * enviando explicitamente valores nulos, tornando o código sujo.
 * */

import br.senai.sc.tasksapipatterns.model.Person;
import br.senai.sc.tasksapipatterns.model.enums.NotificationTypeEnum;

public class PersonBuilder {

    private String name;

    private String email;

    private String phone;

    private String password;

    private NotificationTypeEnum notificationType;

    private PersonBuilder() {

    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public PersonBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder email(String email) {
        this.email = email;
        return this;
    }

    public PersonBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public PersonBuilder password(String password) {
        this.password = password;
        return this;
    }

    public PersonBuilder notificationType(NotificationTypeEnum notificationType) {
        this.notificationType = notificationType;
        return this;
    }

    public Person build() {
        return new Person(this.name,
                this.email,
                this.phone,
                this.password,
                this.notificationType);
    }

}
