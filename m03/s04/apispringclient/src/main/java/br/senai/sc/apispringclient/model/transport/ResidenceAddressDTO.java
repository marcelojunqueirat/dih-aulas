package br.senai.sc.apispringclient.model.transport;

public record ResidenceAddressDTO(String street,
                                  String number,
                                  String district,
                                  String city,
                                  String state,
                                  String complement) {
}
