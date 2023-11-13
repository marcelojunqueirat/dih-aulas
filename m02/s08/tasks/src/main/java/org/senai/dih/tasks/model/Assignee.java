package org.senai.dih.tasks.model;

import jakarta.persistence.*;
import org.senai.dih.tasks.model.transport.create.CreateAssigneeDTO;

import java.time.LocalDate;

@Entity
public class Assignee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDate createdAt;

    public Assignee() {
    }

    public Assignee(CreateAssigneeDTO createAssigneeDTO) {
        this.name = createAssigneeDTO.name();
        this.email = createAssigneeDTO.email();
        this.createdAt = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
