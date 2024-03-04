package br.senai.sc.tasksapipatterns.service;

import br.senai.sc.tasksapipatterns.exceptions.AssignmentNotFoundException;
import br.senai.sc.tasksapipatterns.exceptions.PersonNotFoundException;
import br.senai.sc.tasksapipatterns.model.Assignment;
import br.senai.sc.tasksapipatterns.model.enums.OperationTypeEnum;
import br.senai.sc.tasksapipatterns.model.operations.ApplyAssigneeForm;
import br.senai.sc.tasksapipatterns.model.operations.CreateAssignmentForm;
import br.senai.sc.tasksapipatterns.model.transport.AssignmentDTO;
import br.senai.sc.tasksapipatterns.model.transport.TaskDTO;
import br.senai.sc.tasksapipatterns.repository.AssignmentRepository;
import br.senai.sc.tasksapipatterns.utils.ObjectMapperUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AssignmentService {

    public static final Logger LOGGER = LoggerFactory.getLogger(AssignmentService.class);
    private final TaskService taskService;
    private final AssignmentRepository assignmentRepository;

    public AssignmentService(TaskService taskService, AssignmentRepository assignmentRepository) {
        this.taskService = taskService;
        this.assignmentRepository = assignmentRepository;
    }

    public AssignmentDTO getByGUID(String guid, UserDetails userInSession) throws AssignmentNotFoundException {
        return this.assignmentRepository
                .findByGuidAndDeletedFalseAndPersonEmail(guid, userInSession.getUsername())
                .map(AssignmentDTO::new)
                .orElseThrow(() -> new AssignmentNotFoundException(guid));
    }

    public TaskDTO create(CreateAssignmentForm form, UserDetails userInSession) throws PersonNotFoundException, JsonProcessingException {
        String formAsJson = ObjectMapperUtils.newInstance().toJson(form);
        return this.taskService.execute(OperationTypeEnum.CREATE_ASSIGNMENT, formAsJson, userInSession);
    }

    public TaskDTO delete(String id, UserDetails userInSession) throws PersonNotFoundException {
        return this.taskService.execute(OperationTypeEnum.DELETE_ASSIGNMENT, id, userInSession);
    }

    public TaskDTO applyAssignee(ApplyAssigneeForm form, UserDetails userInSession) throws PersonNotFoundException, JsonProcessingException {
        String formAsJson = ObjectMapperUtils.newInstance().toJson(form);
        return this.taskService.execute(OperationTypeEnum.APPLY_ASSIGNEE, formAsJson, userInSession);
    }

    public Assignment getAssignmentByGUID(String guid) throws AssignmentNotFoundException {
        return this.assignmentRepository.findByGuid(guid)
                .orElseThrow(() -> new AssignmentNotFoundException(""));
    }

    public TaskDTO generateReport(String type, UserDetails userInSession) throws PersonNotFoundException {
        return this.taskService.execute(OperationTypeEnum.GENERATE_REPORT, type, userInSession);
    }
}
