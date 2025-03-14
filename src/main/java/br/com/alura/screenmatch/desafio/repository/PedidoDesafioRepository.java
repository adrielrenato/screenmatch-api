package br.com.alura.screenmatch.desafio.repository;

import br.com.alura.screenmatch.desafio.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoDesafioRepository extends JpaRepository<Pedido, Long> {}