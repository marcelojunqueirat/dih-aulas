package br.senai.sc.tasksapitests.service;

import br.senai.sc.tasksapitests.exceptions.UserNotFoundException;
import br.senai.sc.tasksapitests.model.Person;
import br.senai.sc.tasksapitests.model.transport.operations.create.CreatePersonForm;
import br.senai.sc.tasksapitests.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Captor
    private ArgumentCaptor<Person> personCaptor;

    @Test
    void loadUserByEmailWhenUserIsFound() {
        /* Arrange */
        String email = "user@example.com";
        String exceptionMessage = "User by email not found: " + email;
        Person person = new Person();
        person.setEmail(email);
        person.setPassword(this.passwordEncoder
                .encode("UmaSenhaForte"));

        BDDMockito.given(this.personRepository.findByEmail(email))
                .willReturn(Optional.of(person));

        /* Act & Assert */
        Assertions.assertDoesNotThrow(
                () -> this.personService.findByEmail(email), exceptionMessage);
    }

    @Test
    void loadUserByEmailWhenUserIsNotFound() {
        String email = "user@example.com";
        String exceptionMessage = "User by email not found: " + email;
        BDDMockito.given(this.personRepository.findByEmail(email))
                .willReturn(Optional.empty());

        Assertions.assertThrows(UserNotFoundException.class,
                () -> this.personService.findByEmail(email), exceptionMessage);
    }

    @Test
    void createUserOnDatabaseWithNoFail() {
        /* Arrange */
        CreatePersonForm form =
                new CreatePersonForm("user 01", "user01@example.com", "UmaSenhaForte", null);
        String passwordEncoded = this.passwordEncoder.encode(form.password());

        /* Act*/
        this.personService.create(form);

        verify(this.personRepository).save(this.personCaptor.capture());
        Person createdPerson = this.personCaptor.getValue();

        /* Assertions */
        Assertions.assertEquals(form.name(), createdPerson.getName());
        Assertions.assertEquals(form.email(), createdPerson.getEmail());
        Assertions.assertNotNull(createdPerson.getGuid());
        Assertions.assertEquals(36, createdPerson.getGuid().length());
        Assertions.assertEquals(passwordEncoded, createdPerson.getPassword());
    }
}
