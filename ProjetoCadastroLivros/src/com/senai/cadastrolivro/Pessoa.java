package com.senai.cadastrolivro;

public class Pessoa {
    private String nome;
    private String sobrenome;
    public Pessoa(String nome, String sobrenome) {
        setNome(nome);
        setSobrenome(sobrenome);
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome.trim();
        } else {
            System.out.println("--nome não pode ser null ou vazio--");
        }
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        if (sobrenome != null && !sobrenome.trim().isEmpty()) {
            this.sobrenome = sobrenome.trim();
        } else {
            System.out.println("--Sobrenome não pode ser null ou vazio--");
        }
    }
    public String getNomeCompleto() {
        return nome + " " + sobrenome;
    }
}
