package br.senai.sc.tasksapitests.service;

import br.senai.sc.tasksapitests.exceptions.TaskNotFoundException;
import br.senai.sc.tasksapitests.exceptions.UserNotFoundException;
import br.senai.sc.tasksapitests.model.Person;
import br.senai.sc.tasksapitests.model.Task;
import br.senai.sc.tasksapitests.model.transport.TaskDTO;
import br.senai.sc.tasksapitests.model.transport.operations.create.CreateTaskForm;
import br.senai.sc.tasksapitests.model.transport.operations.update.ApplyAssigneeForm;
import br.senai.sc.tasksapitests.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskService.class);

    private final TaskRepository taskRepository;
    private final PersonService personService;

    public TaskService(TaskRepository taskRepository, PersonService personService) {
        this.taskRepository = taskRepository;
        this.personService = personService;
    }

    @Transactional
    public TaskDTO create(CreateTaskForm form, UserDetails userInSession) throws UserNotFoundException {
        LOGGER.info("Starting task creation...");
        Person person = this.personService.findByEmail(userInSession.getUsername());
        Task task = new Task(form, person);
        this.taskRepository.save(task);
        return new TaskDTO(task);
    }

    @Transactional
    public void delete(String id) throws TaskNotFoundException {
        Task task = getTask(id);
        task.setDeleted(true);
    }

    @Transactional
    public TaskDTO applyAssignee(String id, ApplyAssigneeForm form) throws TaskNotFoundException, UserNotFoundException {
        Task task = this.getTask(id);
        Person person = this.personService.findByGuid(form.id());

        task.getAssignees().add(person);
        return new TaskDTO(task);
    }

    private Task getTask(String id) throws TaskNotFoundException {
        return this.taskRepository.findByGuidAndDeletedFalse(id)
                .orElseThrow(() -> new TaskNotFoundException(String.format("Task not found: %s", id)));
    }

    public Set<TaskDTO> list() {
        return this.taskRepository.findAllByDeletedFalse()
                .stream().map(TaskDTO::new).collect(Collectors.toSet());
    }
}
