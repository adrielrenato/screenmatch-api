package br.com.alura.screenmatch.desafio;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("10", "abc", "20", "30x");
        input.stream() .map(str -> {
            try {
                return Optional.of(Integer.parseInt(str));
            } catch (NumberFormatException e) {
                return Optional.<Integer>empty(); }
        })
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList()
                .forEach(System.out::println);
    }

    public static Optional<Integer> processaNumero(Optional<Integer> numero) {
        return numero.filter(n -> n > 0).map(n -> n * n);
    }

    public static String obterPrimeiroEUltimoNome(String nomeCompleto) {
        String[] nomes = nomeCompleto.trim().split("\\s+");
        if (nomes.length == 1) {
            return nomes[0]; // Apenas um nome
        }
        return nomes[0] + " " + nomes[nomes.length - 1]; // Primeiro e último
    }

    public static boolean ehPalindromo(String palavra) {
        String semEspacos = palavra.replace(" ", "").toLowerCase();
        return new StringBuilder(semEspacos).reverse().toString().equalsIgnoreCase(semEspacos);
    }

    public List<String> converterEmails(List<String> emails) {
        return emails.stream()
                .map(email -> email.trim().toLowerCase())
                .toList();
    }

    public enum Mes {
        JANEIRO(31), FEVEREIRO(28), MARCO(31), ABRIL(30),
        MAIO(31), JUNHO(30), JULHO(31), AGOSTO(31),
        SETEMBRO(30), OUTUBRO(31), NOVEMBRO(30), DEZEMBRO(31);

        private final int dias;

        Mes(int dias) {
            this.dias = dias;
        }

        public int getNumeroDeDias() {
            return dias;
        }
    }

    public enum Moeda {
        DOLAR(5.10), EURO(5.50), REAL(1.0);

        private final double taxa;

        Moeda(double taxa) {
            this.taxa = taxa;
        }

        public double converterPara(double valorEmReais) {
            return valorEmReais / taxa;
        }
    }

    public enum CodigoErro {
        NOT_FOUND(404, "Recurso não encontrado"),
        BAD_REQUEST(400, "Requisição inválida"),
        INTERNAL_SERVER_ERROR(500, "Erro interno do servidor");

        private final int codigo;
        private final String descricao;

        CodigoErro(int codigo, String descricao) {
            this.codigo = codigo;
            this.descricao = descricao;
        }

        public int getCodigo() {
            return codigo;
        }

        public String getDescricao() {
            return descricao;
        }
    }
}
