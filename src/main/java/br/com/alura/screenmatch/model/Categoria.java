package br.com.alura.screenmatch.model;

public enum Categoria {
    ACAO("Action"),
    ROMANCE("Romance"),
    COMEDIA("Comedy"),
    DRAMA("Drama"),
    CRIME("Crime");

    private String categoriaOmbdb;

    Categoria(String categoriaOmbdb) {
        this.categoriaOmbdb = categoriaOmbdb;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmbdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }

        throw new IllegalArgumentException("Nenhuma categoria encontrada para a serie");
    }
}
