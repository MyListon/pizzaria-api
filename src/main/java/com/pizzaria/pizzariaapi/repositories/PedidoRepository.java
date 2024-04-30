package com.pizzaria.pizzariaapi.repositories;

import com.pizzaria.pizzariaapi.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
