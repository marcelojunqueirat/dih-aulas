package br.senai.sc.tasksapipatterns.model;

import br.senai.sc.tasksapipatterns.model.enums.OperationTypeEnum;
import br.senai.sc.tasksapipatterns.model.enums.TaskStatusEnum;
import br.senai.sc.tasksapipatterns.model.transport.TaskDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OperationTypeEnum operation;

    @Column(nullable = false)
    private String description;

    @Column(columnDefinition = "TEXT")
    private String metadata;

    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column
    private TaskStatusEnum status;

    @Column(columnDefinition = "TEXT")
    private String exceptionMessage;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    private Person person;

    public Task() {
    }

    public Task(TaskDTO taskDTO, Person person) {
        this.operation = taskDTO.getOperation();
        this.description = taskDTO.getDescription();
        this.metadata = taskDTO.getMetadata();
        this.createdAt = LocalDateTime.now();
        this.status = taskDTO.getStatus();
        this.exceptionMessage = taskDTO.getExceptionMessage();
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public OperationTypeEnum getOperation() {
        return operation;
    }

    public void setOperation(OperationTypeEnum operation) {
        this.operation = operation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
