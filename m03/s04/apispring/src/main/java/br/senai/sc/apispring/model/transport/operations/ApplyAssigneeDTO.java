package br.senai.sc.apispring.model.transport.operations;

import jakarta.validation.constraints.NotBlank;

public record ApplyAssigneeDTO(@NotBlank String personId) {
}
