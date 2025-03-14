package br.com.alura.screenmatch.desafio.repository;

import br.com.alura.screenmatch.desafio.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDesafioRepository extends JpaRepository<Categoria, Long> {}
