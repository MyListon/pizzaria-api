package com.pizzaria.pizzariaapi.repositories;
import com.pizzaria.pizzariaapi.models.PizzaPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository<PizzaPedido.PizzaPedidoHasIngrediente.Ingrediente, Long> {
}
