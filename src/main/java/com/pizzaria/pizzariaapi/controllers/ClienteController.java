package com.pizzaria.pizzariaapi.controllers;

import com.pizzaria.pizzariaapi.models.Cliente;
import com.pizzaria.pizzariaapi.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    //Implemente os métodos CRUD aqui

    // CREATE
    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteRepository.save(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    // READ
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    // READ by ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        Optional<Cliente> clienteData = clienteRepository.findById(id);
        if (clienteData.isPresent()) {
            Cliente _cliente = clienteData.get();
            _cliente.setNome(cliente.getNome());
            _cliente.setEmail(cliente.getEmail());
            // Adicione outras propriedades a serem atualizadas conforme necessário

            return new ResponseEntity<>(clienteRepository.save(_cliente), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarCliente(@PathVariable Long id) {
        try {
            clienteRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
