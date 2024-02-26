package br.senai.sc.tasksapitests.model.transport.operations.create;

public record CreateResidenceAddressForm(String street,
                                         String number,
                                         String district,
                                         String city,
                                         String state,
                                         String coutry,
                                         String complement) {
}
