package tech.devinhouse.lanchonete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devinhouse.lanchonete.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
