package com.twu.biblioteca;


public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.welcomeMessage();

        Menu menu = new Menu();
        menu.addOption(new Option(1, "List Books"));
        menu.setListener(new OptionListener() {
            @Override
            public void onOptionSelected(Option option) {
                switch (option.getId()) {
                    case 1:
                        Catalogue catalogue = new Catalogue();
                        catalogue.showBookList(catalogue.createBookList());
                        break;
                    default:
                        System.out.println("Insert a valid option");
                        break;
                }
            }
        });

        menu.showOptions();
        menu.getUserOption();
    }

    public void welcomeMessage() {
        System.out.println("Welcome to Biblioteca! Everything is up and running!");
    }

}
