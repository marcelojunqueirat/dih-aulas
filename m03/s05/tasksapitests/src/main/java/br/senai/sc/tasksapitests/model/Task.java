package br.senai.sc.tasksapitests.model;

import br.senai.sc.tasksapitests.model.enums.TaskStatusEnum;
import br.senai.sc.tasksapitests.model.transport.operations.create.CreateTaskForm;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String guid;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private TaskStatusEnum status;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime finishedAt;

    private boolean deleted;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    private Person person;

    @ManyToMany
    @JoinTable(name = "assignees_to_tasks",
            joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Set<Person> assignees = new HashSet<>();

    public Task() {

    }

    public Task(CreateTaskForm form, Person person) {
        this.guid = UUID.randomUUID().toString();
        this.title = form.title();
        this.description = form.description();
        this.status = form.status();
        this.createdAt = LocalDateTime.now();
        this.deleted = false;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TaskStatusEnum status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(LocalDateTime finishedAt) {
        this.finishedAt = finishedAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<Person> getAssignees() {
        return assignees;
    }

    public void setAssignees(Set<Person> assignees) {
        this.assignees = assignees;
    }
}
