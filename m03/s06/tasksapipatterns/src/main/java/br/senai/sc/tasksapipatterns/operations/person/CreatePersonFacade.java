package br.senai.sc.tasksapipatterns.operations.person;

import br.senai.sc.tasksapipatterns.exceptions.InvalidNotificationTypeException;
import br.senai.sc.tasksapipatterns.model.Person;
import br.senai.sc.tasksapipatterns.model.builder.PersonBuilder;
import br.senai.sc.tasksapipatterns.model.operations.CreatePersonForm;
import br.senai.sc.tasksapipatterns.model.transport.PersonDTO;
import br.senai.sc.tasksapipatterns.operations.notification.NotificationTemplateMethod;
import br.senai.sc.tasksapipatterns.repository.PersonRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/*
 * O padrão Facade pode ser usado aqui para suprir a necessidade que temos
 * de fazer a criação funcionar sem inicializar todos os objetos e
 * dependências dentro da classe de serviço.
 *
 * Isso evita que nossa classe de serviço, que tem várias funções para tarefas
 * fique extremamente acoplada aos detalhes de implementação da criação de
 * um usuário, por exemplo. */

@Component
public class CreatePersonFacade extends NotificationTemplateMethod {

    private final PasswordEncoder passwordEncoder;
    private final PersonRepository personRepository;

    public CreatePersonFacade(PasswordEncoder passwordEncoder, PersonRepository personRepository) {
        this.passwordEncoder = passwordEncoder;
        this.personRepository = personRepository;
    }

    @Transactional
    public PersonDTO create(CreatePersonForm form) throws InvalidNotificationTypeException {
        Person person = this.buildPerson(form, this.encodePassword(form.password()));

        this.personRepository.save(person);

        this.sendNotification(person);
        return new PersonDTO(person);
    }

    private void sendNotification(Person person) throws InvalidNotificationTypeException {
        String content = person.getNotificationType() +
                ": Hello user! Welcome to the assignments management platform.";
        super.notify(person, content);
    }

    private Person buildPerson(CreatePersonForm form, String password) {
        return PersonBuilder.builder()
                .name(form.name())
                .email(form.email())
                .phone(form.phone())
                .password(password)
                .notificationType(form.notificationType())
                .build();
    }

    private String encodePassword(String password) {
        return this.passwordEncoder.encode(password);
    }
}
