package br.com.alura.screenmatch.desafio;

import br.com.alura.screenmatch.desafio.model.Categoria;
import br.com.alura.screenmatch.desafio.model.Fornecedor;
import br.com.alura.screenmatch.desafio.model.Pedido;
import br.com.alura.screenmatch.desafio.model.Produto;
import br.com.alura.screenmatch.desafio.repository.CategoriaDesafioRepository;
import br.com.alura.screenmatch.desafio.repository.FornecedorRepository;
import br.com.alura.screenmatch.desafio.repository.PedidoDesafioRepository;
import br.com.alura.screenmatch.desafio.repository.ProdutoDesafioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class PrincipalDesafio implements CommandLineRunner {

    @Autowired
    private ProdutoDesafioRepository produtoDesafioRepository;
    @Autowired
    private CategoriaDesafioRepository categoriaRepository;
    @Autowired
    private PedidoDesafioRepository pedidoDesafioRepository;
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public PrincipalDesafio(ProdutoDesafioRepository produtoDesafioRepository, CategoriaDesafioRepository categoriaRepository, PedidoDesafioRepository pedidoDesafioRepository, FornecedorRepository fornecedorRepository) {
        this.produtoDesafioRepository = produtoDesafioRepository;
        this.categoriaRepository = categoriaRepository;
        this.pedidoDesafioRepository = pedidoDesafioRepository;
        this.fornecedorRepository = fornecedorRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(br.com.alura.screenmatch.desafio.PrincipalDesafio.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Criando categorias
        Categoria categoriaEletronicos = new Categoria(null, "Eletrônicos");
        Categoria categoriaLivros = new Categoria(null, "Livros");

        // Criando fornecedores
        Fornecedor fornecedorTech = new Fornecedor("Tech Supplier");
        Fornecedor fornecedorLivros = new Fornecedor("Livraria Global");
        fornecedorRepository.saveAll(List.of(fornecedorTech, fornecedorLivros));

        Produto produto1 = new Produto("Notebook", 3500.0, categoriaEletronicos);
        Produto produto2 = new Produto("Smartphone", 2500.0, categoriaEletronicos);
        Produto produto3 = new Produto("Livro de Java", 100.0, categoriaLivros);
        Produto produto4 = new Produto("Livro de Spring Boot", 150.0, categoriaLivros);

        produto1.setFornecedor(fornecedorTech);
        produto2.setFornecedor(fornecedorTech);
        produto3.setFornecedor(fornecedorLivros);
        produto4.setFornecedor(fornecedorLivros);

        // Associando produtos às categorias
        categoriaEletronicos.setProdutos(List.of(produto1, produto2));
        categoriaLivros.setProdutos(List.of(produto3, produto4));

        // Salvando categorias (cascateia produtos automaticamente, se configurado)
        categoriaRepository.saveAll(List.of(categoriaEletronicos, categoriaLivros));

        // Criando pedidos e associando produtos
        Pedido pedido1 = new Pedido(1L, LocalDate.now());
        pedido1.setProdutos(List.of(produto1, produto3));
        Pedido pedido2 = new Pedido(2L, LocalDate.now().minusDays(1));
        pedido2.setProdutos(List.of(produto2));
        pedidoDesafioRepository.saveAll(List.of(pedido1, pedido2));

        System.out.println("Produtos na categoria Eletrônicos:");
        categoriaRepository.findById(1L).ifPresent(categoria ->
                categoria.getProdutos().forEach(produto ->
                        System.out.println(" - " + produto.getNome())
                )
        );

        // Testando a persistência e o relacionamento
        System.out.println("Categorias e seus produtos:");
        categoriaRepository.findAll().forEach(categoria -> {
            System.out.println("Categoria: " + categoria.getNome());
            categoria.getProdutos().forEach(produto ->
                    System.out.println(" - Produto: " + produto.getNome())
            );
        });

        System.out.println("\nPedidos e seus produtos:");
        pedidoDesafioRepository.findAll().forEach(p -> {
            System.out.println("Pedido " + p.getId() + ":");
            p.getProdutos().forEach(produto ->
                    System.out.println(" - " + produto.getNome())
            );
        });

        System.out.println("\nProdutos e seus fornecedores:");
        produtoDesafioRepository.findAll().forEach(produto ->
                System.out.println("Produto: " + produto.getNome() +
                        ", Fornecedor: " + produto.getFornecedor().getNome())
        );
    }
}
