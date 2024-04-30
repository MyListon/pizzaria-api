package com.pizzaria.pizzariaapi.repositories;

import com.pizzaria.pizzariaapi.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
