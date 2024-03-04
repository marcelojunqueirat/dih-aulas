package br.senai.sc.tasksapipatterns.model.operations;

import br.senai.sc.tasksapipatterns.model.enums.NotificationTypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreatePersonForm(@NotBlank String name,
                               @NotBlank String email,
                               @NotBlank String phone,
                               @NotBlank String password,
                               @NotNull NotificationTypeEnum notificationType) {
}
