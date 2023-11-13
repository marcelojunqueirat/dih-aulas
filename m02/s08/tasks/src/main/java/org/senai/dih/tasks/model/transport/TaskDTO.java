package org.senai.dih.tasks.model.transport;

import org.senai.dih.tasks.model.Task;
import org.senai.dih.tasks.model.enums.StatusEnum;

import java.time.LocalDate;

public record TaskDTO(Long id, String title, String description, LocalDate finishedAt, StatusEnum status,
                      AssigneeDTO assignee, BoardDTO board) {

    public TaskDTO(Task task) {
        this(task.getId(), task.getTitle(), task.getDescription(), task.getFinishedAt(), task.getStatus(), new AssigneeDTO(task.getAssignee()), new BoardDTO(task.getBoard()));
    }
}
