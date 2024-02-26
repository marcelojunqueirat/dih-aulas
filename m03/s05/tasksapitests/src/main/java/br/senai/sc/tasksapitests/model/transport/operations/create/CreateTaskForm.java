package br.senai.sc.tasksapitests.model.transport.operations.create;

import br.senai.sc.tasksapitests.model.enums.TaskStatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTaskForm(@NotBlank String title,
                             String description,
                             @NotNull TaskStatusEnum status) {
}
