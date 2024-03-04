package br.senai.sc.tasksapipatterns.service;

import br.senai.sc.tasksapipatterns.command.*;
import br.senai.sc.tasksapipatterns.exceptions.PersonNotFoundException;
import br.senai.sc.tasksapipatterns.model.Person;
import br.senai.sc.tasksapipatterns.model.Task;
import br.senai.sc.tasksapipatterns.model.enums.OperationTypeEnum;
import br.senai.sc.tasksapipatterns.model.enums.TaskStatusEnum;
import br.senai.sc.tasksapipatterns.model.transport.TaskDTO;
import br.senai.sc.tasksapipatterns.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskService.class);
    private final ApplicationContext applicationContext;
    private final TaskRepository taskRepository;
    private final PersonService personService;

    public TaskService(ApplicationContext applicationContext, TaskRepository taskRepository, PersonService personService) {
        this.applicationContext = applicationContext;
        this.taskRepository = taskRepository;
        this.personService = personService;
    }

    @Transactional
    public TaskDTO execute(OperationTypeEnum operation, String metadata, UserDetails userInSession) throws PersonNotFoundException {
        LOGGER.info("Starting task execution...");
        TaskDTO newTask =
                new TaskDTO(operation, operation.getDescription(), metadata, TaskStatusEnum.RUNNING, userInSession);

        Person userInSessionEntity = this.personService
                .getPersonByEmail(userInSession.getUsername());
        try {
            TaskCommand command = this.applicationContext.getBean(this.getCommand(operation));
            newTask = command.execute(newTask);
            LOGGER.info("Execution completed. Persisting...");
            newTask.setAsCompleted();
            Task taskEntity = new Task(newTask, userInSessionEntity);
            this.persistTask(taskEntity);

            return newTask;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            newTask.setAsFailed(e.getMessage());
            Task failedTask = new Task(newTask, userInSessionEntity);
            this.persistTask(failedTask);
        }
        return newTask;
    }

    private void persistTask(Task newTask) {
        this.taskRepository.save(newTask);
    }


    private Class<? extends TaskCommand> getCommand(OperationTypeEnum operation) {
        return switch (operation) {
            case DISABLED_USER -> DisablePersonCommand.class;
            case GENERATE_REPORT -> GenerateReportCommand.class;
            case CREATE_ASSIGNMENT -> CreateAssignmentCommand.class;
            case DELETE_ASSIGNMENT -> DeleteAssignmentCommand.class;
            case APPLY_ASSIGNEE -> ApplyAssigneeOnAssignmentCommand.class;
        };
    }
}
