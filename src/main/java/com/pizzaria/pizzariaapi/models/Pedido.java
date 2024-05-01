package com.pizzaria.pizzariaapi.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate dataHora;

    @Embedded
    private Fornada fornada;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public Fornada getFornada() {
        return fornada;
    }

    public void setFornada(Fornada fornada) {
        this.fornada = fornada;
    }

    @Embeddable
    public static class Fornada {

        @Column
        private Long idFornada;

        @Column
        private int numFornada;

        @Column
        private int qtdPizzas;

        public Long getIdFornada() {
            return idFornada;
        }

        public void setIdFornada(Long idFornada) {
            this.idFornada = idFornada;
        }

        public int getNumFornada() {
            return numFornada;
        }

        public void setNumFornada(int numFornada) {
            this.numFornada = numFornada;
        }

        public int getQtdPizzas() {
            return qtdPizzas;
        }

        public void setQtdPizzas(int qtdPizzas) {
            this.qtdPizzas = qtdPizzas;
        }
    }
}