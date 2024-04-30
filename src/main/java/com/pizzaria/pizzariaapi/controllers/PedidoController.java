package com.pizzaria.pizzariaapi.controllers;

import com.pizzaria.pizzariaapi.models.Pedido;
import com.pizzaria.pizzariaapi.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;

    // CREATE
    @PostMapping("/criar-pedido")
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        try {
            Pedido novoPedido = pedidoRepository.save(pedido);
            return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // READ
    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        try {
            List<Pedido> pedidos = pedidoRepository.findAll();
            if (pedidos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(pedidos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // READ by ID
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPedidoPorId(@PathVariable("id") long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (pedido.isPresent()) {
            return new ResponseEntity<>(pedido.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable("id") long id, @RequestBody Pedido pedido) {
        Optional<Pedido> pedidoData = pedidoRepository.findById(id);
        if (pedidoData.isPresent()) {
            Pedido _pedido = pedidoData.get();
            _pedido.setId(pedido.getId());
            _pedido.setTotal(pedido.getTotal());

            // Adicione outras propriedades a serem atualizadas conforme necessário

            return new ResponseEntity<>(pedidoRepository.save(_pedido), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarPedido(@PathVariable("id") long id) {
        try {
            pedidoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
