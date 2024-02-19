package br.senai.sc.apispring.model.transport;

import br.senai.sc.apispring.model.ResidenceAddress;

public record ResidenceAddressDTO(String street,
                                  String number,
                                  String district,
                                  String city,
                                  String state,
                                  String complement) {

    public ResidenceAddressDTO(ResidenceAddress address) {
        this(address.getStreet(), address.getNumber(), address.getDistrict(), address.getCity(), address.getState(), address.getComplement());
    }
}
