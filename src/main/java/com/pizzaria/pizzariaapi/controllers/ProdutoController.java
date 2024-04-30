package com.pizzaria.pizzariaapi.controllers;

import com.pizzaria.pizzariaapi.models.Produto;
import com.pizzaria.pizzariaapi.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    // CREATE
    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        try {
            Produto novoProduto = produtoRepository.save(produto);
            return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // READ
    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {
        try {
            List<Produto> produtos = produtoRepository.findAll();
            if (produtos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(produtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // READ by ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable("id") long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            return new ResponseEntity<>(produto.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable("id") long id, @RequestBody Produto produto) {
        Optional<Produto> produtoData = produtoRepository.findById(id);
        if (produtoData.isPresent()) {
            Produto _produto = produtoData.get();
            _produto.setNome(produto.getNome());
            _produto.setPreco(produto.getPreco());
            // Adicione outras propriedades a serem atualizadas conforme necessário

            return new ResponseEntity<>(produtoRepository.save(_produto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarProduto(@PathVariable("id") long id) {
        try {
            produtoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
