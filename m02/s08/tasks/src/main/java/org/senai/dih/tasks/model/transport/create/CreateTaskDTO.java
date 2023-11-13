package org.senai.dih.tasks.model.transport.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.senai.dih.tasks.model.enums.StatusEnum;

import java.time.LocalDate;

public record CreateTaskDTO(@NotBlank String title, @NotBlank String description, LocalDate finishedAt, @NotNull
StatusEnum status, Long assigneeId, @NotNull Long boardId) {
}
