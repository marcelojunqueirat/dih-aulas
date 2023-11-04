package tech.devinhouse.lanchonete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.devinhouse.lanchonete.model.Cliente;
import java.util.*;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>  {

    Optional<Cliente> findByNome(String nome);

    Optional<Cliente> findByNomeContaining(String nome); // exemplo com like

    boolean existsByNome(String nome);

    // JPQL   --- bind parameters
    @Query("SELECT c FROM Cliente c WHERE c.cpf = :cpf AND c.nome = :nome")
    Optional<Cliente> obterPorCpfENome(Long cpf, String nome);

    @Query(value = "SELECT * FROM clientes WHERE cpf = :cpf AND nome = :nome",
    nativeQuery = true)
    Optional<Cliente> obterPorCpfENome2(Long cpf, String nome);

    @Query("SELECT c FROM Cliente c WHERE nome = :nome")
    List<Cliente> obterPorNome(String nome);

}

