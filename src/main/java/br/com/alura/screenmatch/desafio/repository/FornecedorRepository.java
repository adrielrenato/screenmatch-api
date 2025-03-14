package br.com.alura.screenmatch.desafio.repository;

import br.com.alura.screenmatch.desafio.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {}
