package com.pizzaria.pizzariaapi.repositories;

import com.pizzaria.pizzariaapi.models.Bebida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BebidaRepository extends JpaRepository<Bebida, Long> {
}
