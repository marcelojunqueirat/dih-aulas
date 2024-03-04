package br.senai.sc.tasksapipatterns.model.transport;

import br.senai.sc.tasksapipatterns.model.Assignment;
import br.senai.sc.tasksapipatterns.model.enums.AssignmentStatusEnum;

import java.util.Set;
import java.util.stream.Collectors;

public record AssignmentDTO(String guid,
                            String title,
                            String description,
                            AssignmentStatusEnum status,
                            Set<PersonDTO> assignees) {

    public AssignmentDTO(Assignment assignment) {
        this(assignment.getGuid(),
                assignment.getTitle(),
                assignment.getDescription(),
                assignment.getStatus(),
                assignment.getAssignees().stream().map(PersonDTO::new).collect(Collectors.toSet())
        );
    }
}
