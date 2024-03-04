package br.senai.sc.tasksapipatterns.command;

import br.senai.sc.tasksapipatterns.exceptions.InvalidNotificationTypeException;
import br.senai.sc.tasksapipatterns.model.Assignment;
import br.senai.sc.tasksapipatterns.model.Person;
import br.senai.sc.tasksapipatterns.model.operations.ApplyAssigneeForm;
import br.senai.sc.tasksapipatterns.model.transport.AssignmentDTO;
import br.senai.sc.tasksapipatterns.model.transport.TaskDTO;
import br.senai.sc.tasksapipatterns.operations.notification.NotificationTemplateMethod;
import br.senai.sc.tasksapipatterns.operations.validation.chain.ApplyAssigneeFilterChain;
import br.senai.sc.tasksapipatterns.service.AssignmentService;
import br.senai.sc.tasksapipatterns.service.PersonService;
import br.senai.sc.tasksapipatterns.utils.ObjectMapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Classe que usa o padrão Command para aplicar um determinado usuário como responsável por uma tarefa.
 * Essa classe estende o comportamento do NotificationTemplateMethod, para enviar notificações ao usuário da sessão.
 * E ela implementa o TaskCommand, para que seja entendida como uma classe pertencente aos comandos da aplicação.
 */

@Lazy
@Component
public class ApplyAssigneeOnAssignmentCommand extends NotificationTemplateMethod implements TaskCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplyAssigneeOnAssignmentCommand.class);
    private final PersonService personService;
    private final AssignmentService assignmentService;

    public ApplyAssigneeOnAssignmentCommand(PersonService personService, AssignmentService assignmentService) {
        this.personService = personService;
        this.assignmentService = assignmentService;
    }

    @Override
    @Transactional
    public TaskDTO execute(TaskDTO taskDTO) throws Exception {
        LOGGER.info("Starting assignment creation...");

        /* Usando o Singleton para criar a instância ou recuperar uma existente.*/
        ObjectMapperUtils objectMapperUtils = ObjectMapperUtils.newInstance();

        ApplyAssigneeForm form = objectMapperUtils
                .toObject(taskDTO.getMetadata(), ApplyAssigneeForm.class);

        Assignment assignment = this.assignmentService.getAssignmentByGUID(form.getAssignmentIdentifier());
        Person assignee = this.personService.getPersonByGUIDAndEnabledTrue(form.getUserIdentifier());

        this.executeValidations(assignment, assignee);

        assignment.getAssignees().add(assignee);

        taskDTO.setDetail(assignment.getGuid());
        taskDTO.setMetadata(objectMapperUtils.toJson(new AssignmentDTO(assignment)));

        this.notifyPerson(assignee);
        return taskDTO;
    }

    private void executeValidations(Assignment assignment, Person assignee) throws Exception {
        LOGGER.info("Executing validations...");
        /* Usando o padrão Chain Of Responsibility para definir uma cadeia de validações para
         * essa operação. */
        ApplyAssigneeFilterChain validations =
                new ApplyAssigneeFilterChain(assignment, assignee);
        validations.buildChain().execute();
    }

    private void notifyPerson(Person assignee) throws InvalidNotificationTypeException {
        String content = assignee.getNotificationType() + ": Attention, user! An assignment has been assigned to you.";
        super.notify(assignee, content);
    }
}
