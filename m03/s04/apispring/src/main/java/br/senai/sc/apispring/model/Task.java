package br.senai.sc.apispring.model;

import br.senai.sc.apispring.model.composite.TaskComposite;
import br.senai.sc.apispring.model.enums.TaskStateEnum;
import br.senai.sc.apispring.model.transport.operations.CreateTaskDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Task {

    @EmbeddedId
    private TaskComposite taskComposite;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStateEnum status;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime finishedAt;
    private boolean deleted;

    @ManyToOne
    @JoinColumn(name = "owner_guid", referencedColumnName = "guid", nullable = false)
    @JoinColumn(name = "owner_email", referencedColumnName = "email", nullable = false)
    private Person owner;

    @ManyToMany
    @JoinTable(name = "assignees_to_tasks",
            joinColumns = {@JoinColumn(name = "task_guid", referencedColumnName = "guid"), @JoinColumn(name = "task_title", referencedColumnName = "title")},
            inverseJoinColumns = {@JoinColumn(name = "person_guid", referencedColumnName = "guid"), @JoinColumn(name = "person_email", referencedColumnName = "email")})
    private Set<Person> assignees = new HashSet<>();

    public Task() {

    }

    public Task(CreateTaskDTO task, Person person) {
        String id = UUID.randomUUID().toString();
        this.taskComposite = new TaskComposite(id, task.title());
        this.description = task.description();
        this.status = task.status();
        this.createdAt = LocalDateTime.now();
        this.owner = person;
    }

    public TaskComposite getTaskComposite() {
        return taskComposite;
    }

    public String getDescription() {
        return description;
    }

    public TaskStateEnum getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getFinishedAt() {
        return finishedAt;
    }

    public Person getOwner() {
        return owner;
    }

    public Set<Person> getAssignees() {
        return assignees;
    }
}
