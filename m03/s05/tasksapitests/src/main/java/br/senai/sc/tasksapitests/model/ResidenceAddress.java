package br.senai.sc.tasksapitests.model;

import br.senai.sc.tasksapitests.model.transport.operations.create.CreateResidenceAddressForm;
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

    @Column(nullable = false)
    private String country;

    private String complement;

    public ResidenceAddress() {

    }

    public ResidenceAddress(CreateResidenceAddressForm form) {
        this.street = form.street();
        this.number = form.number();
        this.district = form.district();
        this.city = form.city();
        this.state = form.state();
        this.country = form.coutry();
        this.complement = form.complement();
    }
}
