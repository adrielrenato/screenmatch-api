package br.com.alura.screenmatch.desafio.repository;

import br.com.alura.screenmatch.desafio.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoDesafioRepository extends JpaRepository<Produto, Long> {
//    List<Produto> findByNome(String nome);
//    List<Produto> findByCategoriaNome(String categoriaNome);
//    List<Produto> findByPrecoGreaterThan(Double preco);
//    List<Produto> findByPrecoLessThan(Double preco);
//    List<Produto> findByNomeContaining(String termo);
//    List<Produto> findByCategoriaNomeOrderByPrecoAsc(String categoriaNome);
//    List<Produto> findByCategoriaNomeOrderByPrecoDesc(String categoriaNome);
//    long countByCategoriaNome(String categoriaNome);
//    long countByPrecoGreaterThan(Double preco);
//    List<Produto> findByPrecoLessThanOrNomeContaining(Double preco, String termo);
//    List<Produto> findTop3ByPrecoDesc();
//    List<Produto> findTop5ByCategoriaNomeOrderByPrecoAsc(String categoriaNome);
    @Query("SELECT p FROM Produto p WHERE p.preco > :preco")
    List<Produto> buscarPorPrecoMaior(@Param("preco") Double preco);

    @Query("SELECT p FROM Produto p ORDER BY p.preco ASC")
    List<Produto> buscarOrdenadoPorPrecoAsc();

    @Query("SELECT p FROM Produto p ORDER BY p.nome DESC")
    List<Produto> buscarOrdenadoPorNomeDesc();

    @Query("SELECT AVG(p.preco) FROM Produto p")
    Double calcularMediaPrecoProdutos();

    @Query("SELECT MAX(p.preco) FROM Produto p WHERE p.categoria.nome = :categoria")
    Double buscarPrecoMaximoPorCategoria(@Param("categoria") String categoria);

    @Query("SELECT c.nome, COUNT(p) FROM Produto p JOIN p.categoria c GROUP BY c.nome")
    List<Object[]> contarProdutosPorCategoria();

    @Query("SELECT c.nome, COUNT(p) FROM Produto p JOIN p.categoria c GROUP BY c.nome HAVING COUNT(p) > :quantidade")
    List<Object[]> categoriasComMaisDe(@Param("quantidade") long quantidade);

    @Query("SELECT p FROM Produto p WHERE (:nome IS NULL OR p.nome = :nome) AND (:categoria IS NULL OR p.categoria.nome = :categoria)")
    List<Produto> buscarProdutosFiltrados(@Param("nome") String nome, @Param("categoria") String categoria);

    @Query(value = "SELECT * FROM produto ORDER BY preco DESC LIMIT 5", nativeQuery = true)
    List<Produto> buscarTop5ProdutosMaisCaros();
}
