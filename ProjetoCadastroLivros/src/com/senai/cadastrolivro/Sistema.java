package com.senai.cadastrolivro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private static Scanner scan = new Scanner(System.in);
    private static List<Livro> livros = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            while (!scan.hasNextInt()) {
                System.out.println("Opção inválida. Tente novamente.");
                scan.next();
            }
            opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    verTodosLivros();
                    break;
                case 3:
                    verLivrosPorGenero();
                    break;
                case 4:
                    buscarLivro();
                    break;
                case 9:
                    System.out.println("Tchau");
                    break;
                default:
                    System.out.println("Opção inválida Tente novamente.");
            }
        } while (opcao != 9);
    }

    private static void exibirMenu() {
        System.out.println("\nSistema de Cadastro de Livros");
        System.out.println("1 - Cadastrar novo livro");
        System.out.println("2 - Ver todos os livros");
        System.out.println("3 - Ver todos os livros de um gênero");
        System.out.println("4 - Buscar um livro por título ou autor");
        System.out.println("9 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarLivro() {
        System.out.print("Digite o título do livro: ");
        String titulo = scan.nextLine();

        System.out.print("Digite o nome do autor: ");
        String nomeAutor = scan.nextLine();
        System.out.print("Digite o sobrenome do autor: ");
        String sobrenomeAutor = scan.nextLine();
        Pessoa autor = new Pessoa(nomeAutor, sobrenomeAutor);

        System.out.println("Escolha o gênero do livro:");
        for (Genero g : Genero.values()) {
            System.out.println(g.getCodigo() + " - " + g.getNome());
        }
        int codigoGenero = scan.nextInt();
        scan.nextLine();
        Genero genero = Genero.getByCodigo(codigoGenero);

        if (genero == null) {
            System.out.println("Gênero inválido.");
            return;
        }

        Livro livro = new Livro(titulo, autor, genero);
        livros.add(livro);

        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void verTodosLivros() {
        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados.");
        } else {
            System.out.println("\nLivros cadastrados:");
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    private static void verLivrosPorGenero() {
        System.out.println("Escolha o gênero:");
        for (Genero g : Genero.values()) {
            System.out.println(g.getCodigo() + " - " + g.getNome());
        }
        int codigoGenero = scan.nextInt();
        scan.nextLine();
        Genero genero = Genero.getByCodigo(codigoGenero);

        if (genero == null) {
            System.out.println("Gênero inválido.");
            return;
        }

        System.out.println("\nLivros do gênero " + genero.getNome() + ":");
        for (Livro livro : livros) {
            if (livro.getGenero() == genero) {
                System.out.println(livro);
            }
        }
    }
    private static void buscarLivro() {
        System.out.print("Digite o título ou o nome do autor: ");
        String busca = scan.nextLine().toLowerCase();

        boolean encontrado = false;
        for (Livro livro : livros) {
            if (livro.getTitulo().toLowerCase().contains(busca) || livro.getAutor().getNomeCompleto().toLowerCase().contains(busca)) {
                System.out.println(livro);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum livro encontrado.");
        }
    }
}
