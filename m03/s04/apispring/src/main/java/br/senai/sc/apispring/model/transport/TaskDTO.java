package br.senai.sc.apispring.model.transport;

import br.senai.sc.apispring.model.Task;
import br.senai.sc.apispring.model.enums.TaskStateEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public record TaskDTO(String guid,
                      String title,
                      String description,
                      TaskStateEnum status,
                      @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
                      LocalDateTime createdAt,
                      LocalDateTime finishedAt,
                      PersonDTO owner,
                      Set<PersonDTO> assignees) {

    public TaskDTO(Task task) {
        this(task.getTaskComposite().getGuid(),
                task.getTaskComposite().getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getCreatedAt(),
                task.getFinishedAt(),
                new PersonDTO(task.getOwner()),
                task.getAssignees().stream().map(PersonDTO::new).collect(Collectors.toSet()));
    }
}
