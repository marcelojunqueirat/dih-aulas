package org.senai.dih.tasks.model.transport.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateAssigneeDTO(@NotBlank String name, @NotBlank @Email String email) {
}
