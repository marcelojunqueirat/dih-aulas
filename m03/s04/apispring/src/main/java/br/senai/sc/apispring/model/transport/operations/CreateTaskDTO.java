package br.senai.sc.apispring.model.transport.operations;

import br.senai.sc.apispring.model.enums.TaskStateEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTaskDTO(@NotBlank String title,
                            @NotBlank String description,
                            @NotNull TaskStateEnum status) {
}
