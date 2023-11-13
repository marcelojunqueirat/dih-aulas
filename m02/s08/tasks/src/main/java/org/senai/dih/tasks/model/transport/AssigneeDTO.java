package org.senai.dih.tasks.model.transport;

import org.senai.dih.tasks.model.Assignee;

import java.time.LocalDate;

public record AssigneeDTO(Long id, String name, String email, LocalDate createdAt) {

    public AssigneeDTO(Assignee assignee) {
        this(assignee.getId(), assignee.getName(), assignee.getEmail(), assignee.getCreatedAt());
    }
}
