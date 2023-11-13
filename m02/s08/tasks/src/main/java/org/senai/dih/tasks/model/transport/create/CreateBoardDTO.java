package org.senai.dih.tasks.model.transport.create;

import jakarta.validation.constraints.NotBlank;

public record CreateBoardDTO(@NotBlank String name, @NotBlank String description) {
}
