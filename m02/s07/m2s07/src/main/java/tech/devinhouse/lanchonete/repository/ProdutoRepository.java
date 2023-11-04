package tech.devinhouse.lanchonete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devinhouse.lanchonete.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {
}
