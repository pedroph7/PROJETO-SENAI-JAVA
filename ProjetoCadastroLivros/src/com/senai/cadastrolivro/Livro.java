package com.senai.cadastrolivro;

import java.util.Map;
import java.util.HashMap;

public class Livro {
    private String titulo;
    private Pessoa autor;
    private Genero genero;
    private Map<String, String> caracteristicas;

    // Constructor
    public Livro(String titulo, Pessoa autor, Genero genero) {
        setTitulo(titulo);
        setAutor(autor);
        setGenero(genero);
        this.caracteristicas = new HashMap<>();
    }

    // Getters and Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.trim().isEmpty()) {
            this.titulo = titulo;
        } else {
            throw new IllegalArgumentException("--Título na pode ser nulo ou vazo--");
        }
    }

    public Pessoa getAutor() {
        return autor;
    }

    public void setAutor(Pessoa autor) {
        if (autor != null) {
            this.autor = autor;
        } else {
            throw new IllegalArgumentException("--Autor nao pode ser nulo--");
        }
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        if (genero != null) {
            this.genero = genero;
        } else {
            throw new IllegalArgumentException("--Gênero não pode ser nulo--");
        }
    }

    public Map<String, String> getCaracteristicas() {
        return caracteristicas;
    }

    public void adicionarCaracteristica(String chave, String valor) {
        if (chave != null && valor != null) {
            caracteristicas.put(chave, valor);
        } else {
            throw new IllegalArgumentException("Chave e valor não podem ser nulos");
        }
    }

    public void removerCaracteristica(String chave) {
        if (chave != null) {
            caracteristicas.remove(chave);
        } else {
            throw new IllegalArgumentException("Chave não pode ser nula");
        }
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor.getNomeCompleto() + ", Gênero: " + genero.getNome();
    }
}
