package br.senai.sc.tasksapipatterns.model.transport;

import br.senai.sc.tasksapipatterns.model.enums.OperationTypeEnum;
import br.senai.sc.tasksapipatterns.model.enums.TaskStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.security.core.userdetails.UserDetails;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskDTO {

    private final OperationTypeEnum operation;
    private final String description;
    private String metadata;
    private TaskStatusEnum status;
    private String detail;
    private String exceptionMessage;

    @JsonIgnore
    private final UserDetails userInSession;

    public TaskDTO(OperationTypeEnum operation, String description, String metadata, TaskStatusEnum status, UserDetails userInSession) {
        this.operation = operation;
        this.description = description;
        this.metadata = metadata;
        this.status = status;
        this.userInSession = userInSession;
    }

    public OperationTypeEnum getOperation() {
        return operation;
    }

    public String getDescription() {
        return description;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public TaskStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TaskStatusEnum status) {
        this.status = status;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public UserDetails getUserInSession() {
        return userInSession;
    }

    public void setAsCompleted() {
        this.setStatus(TaskStatusEnum.SUCCESS);
    }

    public void setAsFailed(String message) {
        this.setStatus(TaskStatusEnum.FAILED);
        this.setExceptionMessage(message);
    }
}

