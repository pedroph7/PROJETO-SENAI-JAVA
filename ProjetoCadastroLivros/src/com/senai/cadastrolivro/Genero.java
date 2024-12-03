package com.senai.cadastrolivro;

public enum Genero {
    AUTOAJUDA(1, "Autoajuda"),
    BIOGRAFIAS_E_HISTORIAS_REAIS(2, "Biografias e Histórias Reais"),
    EDUCACAO_E_DIDATICOS(3, "Educação e Didáticos"),
    HISTORIA(4, "História"),
    HQS_MANGAS_E_GRAPHIC_NOVELS(5, "HQs, Mangás e Graphic Novels"),
    INFANTIL(6, "Infantil"),
    LITERATURA_E_FICCAO(7, "Literatura e Ficção"),
    RELIGIAO_E_ESPIRITUALIDADE(8, "Religião e Espiritualidade"),
    ROMANCE(9, "Romance"),
    SUSPENSE(10, "Suspense");

    private int codigo;
    private  String nome;

    Genero(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }

    public static Genero getByCodigo(int codigo) {
        for (Genero g : values()) {
            if (g.getCodigo() == codigo) {
                return g;
            }
        }
        return null;
    }
}
