package br.senai.sc.apispringclient.model.transport;


public record PersonDTO(String guid,
                        String email,
                        String name,
                        ResidenceAddressDTO address) {
}
