package br.senai.sc.tasksapitests.service;

import br.senai.sc.tasksapitests.exceptions.TaskNotFoundException;
import br.senai.sc.tasksapitests.exceptions.UserNotFoundException;
import br.senai.sc.tasksapitests.model.Person;
import br.senai.sc.tasksapitests.model.Task;
import br.senai.sc.tasksapitests.model.enums.TaskStatusEnum;
import br.senai.sc.tasksapitests.model.transport.TaskDTO;
import br.senai.sc.tasksapitests.model.transport.operations.create.CreateTaskForm;
import br.senai.sc.tasksapitests.model.transport.operations.update.ApplyAssigneeForm;
import br.senai.sc.tasksapitests.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;


@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private PersonService personService;

    @InjectMocks
    private TaskService taskService;

    @Captor
    private ArgumentCaptor<Task> taskCaptor;

    @Test
    void applyAssigneeReturnsSuccess() throws UserNotFoundException, TaskNotFoundException {
        String id = UUID.randomUUID().toString();
        String userGuid = UUID.randomUUID().toString();

        ApplyAssigneeForm form = new ApplyAssigneeForm(userGuid);

        Person person = new Person();
        person.setGuid(userGuid);

        Task task = new Task();
        task.setGuid(id);

        BDDMockito.given(this.taskRepository
                .findByGuidAndDeletedFalse(id)).willReturn(Optional.of(task));

        BDDMockito.given(this.personService
                .findByGuid(userGuid)).willReturn(person);

        TaskDTO taskDTO = this.taskService.applyAssignee(id, form);

        Assertions.assertEquals(1, taskDTO.assignees().size());
    }

    @Test
    void createTaskReturnsSuccess() throws UserNotFoundException {
        String email = "user@example.com";
        Person person = new Person();
        person.setEmail(email);

        BDDMockito.given(this.personService.findByEmail(email)).willReturn(person);

        CreateTaskForm form =
                new CreateTaskForm("Atividade 01", "Descrição 01", TaskStatusEnum.NOT_STARTED);

        this.taskService.create(form, person);

//        verify(this.taskRepository).save(this.taskCaptor.capture());
        BDDMockito.then(this.taskRepository).should()
                .save(this.taskCaptor.capture());
        Task createdTask = this.taskCaptor.getValue();

        Assertions.assertEquals(form.title(), createdTask.getTitle());
        Assertions.assertEquals(person.getEmail(), createdTask.getPerson().getEmail());
        Assertions.assertNotNull(createdTask.getGuid());
        Assertions.assertNotNull(createdTask.getCreatedAt());
    }
}
