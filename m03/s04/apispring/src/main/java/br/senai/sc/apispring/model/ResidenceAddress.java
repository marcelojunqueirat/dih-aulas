package br.senai.sc.apispring.model;

import br.senai.sc.apispring.model.transport.operations.CreateResidenceAddressDTO;
import jakarta.persistence.*;

@Entity
public class ResidenceAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String district;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    private String complement;

    public ResidenceAddress() {

    }

    public ResidenceAddress(CreateResidenceAddressDTO address) {
        this.street = address.street();
        this.number = address.number();
        this.district = address.district();
        this.city = address.city();
        this.state = address.state();
        this.complement = address.complement();
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getDistrict() {
        return district;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getComplement() {
        return complement;
    }
}
