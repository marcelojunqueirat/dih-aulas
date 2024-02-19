package br.senai.sc.apispringclient.model.transport.operations;

import br.senai.sc.apispringclient.model.enums.TaskStateEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTaskDTO(@NotBlank String title,
                            @NotBlank String description,
                            @NotNull TaskStateEnum status) {
}
