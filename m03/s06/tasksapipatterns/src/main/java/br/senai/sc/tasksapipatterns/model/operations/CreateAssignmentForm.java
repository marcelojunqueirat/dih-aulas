package br.senai.sc.tasksapipatterns.model.operations;

import br.senai.sc.tasksapipatterns.model.enums.AssignmentStatusEnum;
import br.senai.sc.tasksapipatterns.model.enums.FileStorageTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateAssignmentForm(@NotBlank String title,
                                   String description,
                                   @NotNull AssignmentStatusEnum status,
                                   @NotNull FileStorageTypeEnum storageType,
                                   @NotNull Boolean enabledAssignments) {
}
