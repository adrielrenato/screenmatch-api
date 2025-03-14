package br.com.alura.screenmatch.desafio.repository;

import br.com.alura.screenmatch.desafio.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoDesafioRepository extends JpaRepository<Produto, Long> {}
