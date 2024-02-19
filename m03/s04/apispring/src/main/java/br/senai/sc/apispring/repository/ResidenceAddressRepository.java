package br.senai.sc.apispring.repository;

import br.senai.sc.apispring.model.ResidenceAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidenceAddressRepository extends JpaRepository<ResidenceAddress, Long> {
}
