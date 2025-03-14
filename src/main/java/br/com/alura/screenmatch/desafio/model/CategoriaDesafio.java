package br.com.alura.screenmatch.desafio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CategoriaDesafio {
    @Id
    private Long id;
    private String nome;

    public CategoriaDesafio() {}

    public CategoriaDesafio(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
