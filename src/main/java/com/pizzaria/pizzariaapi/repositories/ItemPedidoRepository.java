package com.pizzaria.pizzariaapi.repositories;

import com.pizzaria.pizzariaapi.models.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
