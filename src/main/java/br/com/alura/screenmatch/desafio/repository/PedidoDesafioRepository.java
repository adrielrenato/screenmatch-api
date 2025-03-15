package br.com.alura.screenmatch.desafio.repository;

import br.com.alura.screenmatch.desafio.model.Pedido;
import br.com.alura.screenmatch.desafio.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PedidoDesafioRepository extends JpaRepository<Pedido, Long> {
//    List<Pedido> findByDataEntregaIsNull();
//    List<Pedido> findByDataEntregaIsNotNull();
//    List<Pedido> findByDataPedidoAfter(LocalDate data);
//    List<Pedido> findByDataPedidoBefore(LocalDate data);
//    List<Pedido> findByDataPedidoBetween(LocalDate dataInicio, LocalDate dataFim);
    @Query("SELECT p FROM Produto p WHERE p.nome LIKE :letra%")
    List<Produto> buscarProdutosPorLetraInicial(@Param("letra") String letra);

    @Query("SELECT p FROM Pedido p WHERE p.dataPedido BETWEEN :inicio AND :fim")
    List<Pedido> buscarPedidosPorPeriodo(@Param("inicio") LocalDate inicio, @Param("fim") LocalDate fim);
}