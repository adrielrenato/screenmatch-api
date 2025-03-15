package br.com.alura.screenmatch.desafio.repository;

import br.com.alura.screenmatch.desafio.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PedidoDesafioRepository extends JpaRepository<Pedido, Long> {
//    List<Pedido> findByDataEntregaIsNull();
//    List<Pedido> findByDataEntregaIsNotNull();
//    List<Pedido> findByDataPedidoAfter(LocalDate data);
//    List<Pedido> findByDataPedidoBefore(LocalDate data);
//    List<Pedido> findByDataPedidoBetween(LocalDate dataInicio, LocalDate dataFim);
}