package br.com.alura.screenmatch.desafio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Pedido {
    @Id
    private Long id;
    private LocalDate data;

    public Pedido() {}

    public Pedido(Long id, LocalDate data) {
        this.id = id;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }
}
