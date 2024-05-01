package com.pizzaria.pizzariaapi.repositories;

import com.pizzaria.pizzariaapi.models.PizzaPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaPedidoRepository extends JpaRepository<PizzaPedido, Long> {
    List<PizzaPedido> findByPedidoId(Long idPedido);
}
