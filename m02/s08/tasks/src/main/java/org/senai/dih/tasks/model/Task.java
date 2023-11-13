package org.senai.dih.tasks.model;

import jakarta.persistence.*;
import org.senai.dih.tasks.model.enums.StatusEnum;
import org.senai.dih.tasks.model.transport.create.CreateTaskDTO;

import java.time.LocalDate;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    private LocalDate finishedAt;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @ManyToOne
    @JoinColumn(name = "assignee_id", referencedColumnName = "id")
    private Assignee assignee;

    @ManyToOne
    @JoinColumn(name = "board_id", referencedColumnName = "id", nullable = false)
    private Board board;

    public Task() {
    }

    public Task(CreateTaskDTO taskDTO, Assignee assignee, Board board) {
        this.title = taskDTO.title();
        this.description = taskDTO.description();
        this.finishedAt = taskDTO.finishedAt();
        this.status = taskDTO.status();
        this.assignee = assignee;
        this.board = board;
    }

    public Long getId() {
        return id;
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

    public LocalDate getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(LocalDate finishedAt) {
        this.finishedAt = finishedAt;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }

    public Board getBoard() {
        return board;
    }
}
