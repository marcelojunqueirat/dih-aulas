package br.senai.sc.tasksapipatterns.command;

import br.senai.sc.tasksapipatterns.exceptions.InvalidNotificationTypeException;
import br.senai.sc.tasksapipatterns.model.Assignment;
import br.senai.sc.tasksapipatterns.model.Person;
import br.senai.sc.tasksapipatterns.model.transport.TaskDTO;
import br.senai.sc.tasksapipatterns.operations.notification.NotificationTemplateMethod;
import br.senai.sc.tasksapipatterns.operations.validation.chain.DeleteAssignmentFilterChain;
import br.senai.sc.tasksapipatterns.service.AssignmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/*Classe de comando para deletar uma atividade*/

@Lazy
@Component
public class DeleteAssignmentCommand extends NotificationTemplateMethod implements TaskCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteAssignmentCommand.class);
    private final AssignmentService assignmentService;

    public DeleteAssignmentCommand(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @Override
    @Transactional
    public TaskDTO execute(TaskDTO taskDTO) throws Exception {
        LOGGER.info("Starting assignment deletion...");
        String assignmentIdentifier = taskDTO.getMetadata();

        Assignment assignment = this.assignmentService.getAssignmentByGUID(assignmentIdentifier);
        UserDetails userInSession = taskDTO.getUserInSession();
        this.executeValidations(assignment, userInSession);

        assignment.setDeleted(true);

        this.notifyPerson(assignment);
        return taskDTO;
    }

    private void notifyPerson(Assignment assignment) throws InvalidNotificationTypeException {
        Person person = assignment.getPerson();
        String content = person.getNotificationType() +
                ": Attention, user! An assignment has been removed from your account.";
        super.notify(person, content);
    }

    private void executeValidations(Assignment assignment, UserDetails userInSession) throws Exception {
        LOGGER.info("Executing validations...");
        DeleteAssignmentFilterChain validations =
                new DeleteAssignmentFilterChain(assignment, userInSession);
        validations.buildChain().execute();
    }
}
