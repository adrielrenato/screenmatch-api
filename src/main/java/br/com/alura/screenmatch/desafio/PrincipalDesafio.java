package br.com.alura.screenmatch.desafio;

import br.com.alura.screenmatch.desafio.model.CategoriaDesafio;
import br.com.alura.screenmatch.desafio.model.Pedido;
import br.com.alura.screenmatch.desafio.model.Produto;
import br.com.alura.screenmatch.desafio.repository.CategoriaDesafioRepository;
import br.com.alura.screenmatch.desafio.repository.PedidoDesafioRepository;
import br.com.alura.screenmatch.desafio.repository.ProdutoDesafioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

public class PrincipalDesafio implements CommandLineRunner {

    @Autowired
    private ProdutoDesafioRepository produtoDesafioRepository;
    @Autowired
    private CategoriaDesafioRepository categoriaRepository;
    @Autowired
    private PedidoDesafioRepository pedidoDesafioRepository;

    public PrincipalDesafio(ProdutoDesafioRepository produtoDesafioRepository, CategoriaDesafioRepository categoriaRepository, PedidoDesafioRepository pedidoDesafioRepository) {
        this.produtoDesafioRepository = produtoDesafioRepository;
        this.categoriaRepository = categoriaRepository;
        this.pedidoDesafioRepository = pedidoDesafioRepository;
    }

    public static void main(String[] args) {
//        SpringApplication.run(br.com.alura.screenmatch.ScreenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Produto produto = new Produto("Notebook", 3500.0);
        CategoriaDesafio categoriaDesafio = new CategoriaDesafio(1L, "Eletrônicos");
        Pedido pedido = new Pedido(1L, LocalDate.now());

        this.produtoDesafioRepository.save(produto);
        this.categoriaRepository.save(categoriaDesafio);
        this.pedidoDesafioRepository.save(pedido);
    }
}
