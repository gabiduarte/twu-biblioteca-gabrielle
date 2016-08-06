package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.welcomeMessage();

        Catalogue catalogue = new Catalogue();
        catalogue.showBookList(catalogue.createBookList());
    }

    public void welcomeMessage() {
        System.out.println("Welcome to Biblioteca! Everything is up and running!");
    }

}
