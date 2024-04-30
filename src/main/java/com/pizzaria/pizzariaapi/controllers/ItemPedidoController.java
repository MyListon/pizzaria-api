package com.pizzaria.pizzariaapi.controllers;

import com.pizzaria.pizzariaapi.models.ItemPedido;
import com.pizzaria.pizzariaapi.repositories.ItemPedidoRepository;
import com.pizzaria.pizzariaapi.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


import java.util.List;
import java.util.Optional;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@RestController
@RequestMapping("/pedidos")
public class ItemPedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    // CREATE
    @PostMapping
    public ResponseEntity<ItemPedido> criarItemPedido(@RequestBody ItemPedido itemPedido) {
        try {
            ItemPedido novoItemPedido = itemPedidoRepository.save(itemPedido);
            return new ResponseEntity<>(novoItemPedido, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // READ
    @GetMapping
    public ResponseEntity<List<ItemPedido>> listarItensPedido() {
        try {
            List<ItemPedido> itensPedido = itemPedidoRepository.findAll();
            if (itensPedido.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(itensPedido, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // READ by ID
    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> buscarItemPedidoPorId(@PathVariable("id") long id) {
        try {
            Optional<ItemPedido> itemPedidoOptional = itemPedidoRepository.findById(id);
            if (itemPedidoOptional.isPresent()) {
                ItemPedido itemPedido = itemPedidoOptional.get();
//                log.info("ItemPedido encontrado: {}");
                return new ResponseEntity<>(itemPedido, HttpStatus.OK);
            } else {
//                log.info("ItemPedido com ID {} não encontrado");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
//            log.error("Ocorreu um erro ao buscar o ItemPedido com o ID {}", id, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ItemPedido> atualizarItemPedido(@PathVariable("id") long id, @RequestBody ItemPedido itemPedido) {
        try {
            Optional<ItemPedido> itemPedidoData = itemPedidoRepository.findById(id);
            if (itemPedidoData.isPresent()) {
                ItemPedido _itemPedido = itemPedidoData.get();
                _itemPedido.setProduto(itemPedido.getProduto());
                _itemPedido.setQuantidade(itemPedido.getQuantidade());
                // Adicione outras propriedades a serem atualizadas conforme necessário

                ItemPedido itemPedidoAtualizado = itemPedidoRepository.save(_itemPedido);
                return new ResponseEntity<>(itemPedidoAtualizado, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarItemPedido(@PathVariable("id") long id) {
        try {
            itemPedidoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
