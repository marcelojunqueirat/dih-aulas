package br.senai.sc.tasksapitests.model.transport.operations.update;

import jakarta.validation.constraints.NotBlank;

public record ApplyAssigneeForm(@NotBlank String id) {
}
