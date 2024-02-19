package br.senai.sc.apispring.model.transport.operations;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreatePersonDTO(@NotBlank String email,
                              @NotBlank String name,
                              @NotBlank String password,
                              @NotNull @Valid CreateResidenceAddressDTO address) {
}
