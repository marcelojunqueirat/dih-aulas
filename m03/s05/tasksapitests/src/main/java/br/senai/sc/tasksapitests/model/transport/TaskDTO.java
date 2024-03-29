package br.senai.sc.tasksapitests.model.transport;


import br.senai.sc.tasksapitests.model.Task;
import br.senai.sc.tasksapitests.model.enums.TaskStatusEnum;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public record TaskDTO(String guid, String title, String description, TaskStatusEnum status, LocalDateTime createdAt,
                      LocalDateTime finishedAt, Set<PersonDTO> assignees) {

    public TaskDTO(Task task) {
        this(task.getGuid(), task.getTitle(), task.getDescription(), task.getStatus(), task.getCreatedAt(),
                task.getFinishedAt(), task.getAssignees().stream().map(PersonDTO::new).collect(Collectors.toSet()));
    }
}
