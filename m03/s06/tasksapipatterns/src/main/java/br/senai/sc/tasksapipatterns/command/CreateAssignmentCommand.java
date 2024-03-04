package br.senai.sc.tasksapipatterns.command;

import br.senai.sc.tasksapipatterns.exceptions.InvalidNotificationTypeException;
import br.senai.sc.tasksapipatterns.exceptions.PersonNotFoundException;
import br.senai.sc.tasksapipatterns.model.Assignment;
import br.senai.sc.tasksapipatterns.model.Person;
import br.senai.sc.tasksapipatterns.model.operations.CreateAssignmentForm;
import br.senai.sc.tasksapipatterns.model.transport.AssignmentDTO;
import br.senai.sc.tasksapipatterns.model.transport.TaskDTO;
import br.senai.sc.tasksapipatterns.operations.notification.NotificationTemplateMethod;
import br.senai.sc.tasksapipatterns.repository.AssignmentRepository;
import br.senai.sc.tasksapipatterns.service.PersonService;
import br.senai.sc.tasksapipatterns.utils.ObjectMapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/* Classe para criar uma atividade na base de dados.*/

@Lazy
@Component
public class CreateAssignmentCommand extends NotificationTemplateMethod implements TaskCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAssignmentCommand.class);
    private final PersonService personService;
    private final AssignmentRepository assignmentRepository;

    public CreateAssignmentCommand(PersonService personService, AssignmentRepository assignmentRepository) {
        this.personService = personService;
        this.assignmentRepository = assignmentRepository;
    }

    @Override
    @Transactional
    public TaskDTO execute(TaskDTO taskDTO) throws Exception {
        LOGGER.info("Starting assignment creation...");
        ObjectMapperUtils objectMapperUtils = ObjectMapperUtils.newInstance();

        CreateAssignmentForm form = objectMapperUtils
                .toObject(taskDTO.getMetadata(), CreateAssignmentForm.class);

        Person userInSession = this.getUserInSession(taskDTO);

        Assignment assignment = new Assignment(form, userInSession);
        this.assignmentRepository.save(assignment);

        LOGGER.info("Starting assignment synchronization on selected storage mode...");
        form.storageType().getFileStorageAdapter().synchronize("/assignments");

        taskDTO.setDetail(assignment.getGuid());
        taskDTO.setMetadata(objectMapperUtils.toJson(new AssignmentDTO(assignment)));

        this.notifyPerson(userInSession);
        return taskDTO;
    }

    private void notifyPerson(Person userInSession) throws InvalidNotificationTypeException {
        String content = userInSession.getNotificationType() + ": Attention, user! A new assignment has been created in your account.";
        super.notify(userInSession, content);
    }

    private Person getUserInSession(TaskDTO taskDTO) throws PersonNotFoundException {
        UserDetails userInSession = taskDTO.getUserInSession();
        return this.personService
                .getPersonByEmail(userInSession.getUsername());
    }
}
