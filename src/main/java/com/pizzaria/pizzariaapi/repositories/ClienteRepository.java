package com.pizzaria.pizzariaapi.repositories;

import com.pizzaria.pizzariaapi.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
