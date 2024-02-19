package br.senai.sc.apispring.model.transport.operations;

import jakarta.validation.constraints.NotBlank;

public record CreateResidenceAddressDTO(@NotBlank String street,
                                        @NotBlank String number,
                                        @NotBlank String district,
                                        @NotBlank String city,
                                        @NotBlank String state,
                                        String complement) {
}
