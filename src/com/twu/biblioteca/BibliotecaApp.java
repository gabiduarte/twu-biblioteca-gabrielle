package com.twu.biblioteca;


import com.twu.biblioteca.control.Catalogue;
import com.twu.biblioteca.control.Menu;
import com.twu.biblioteca.misc.OptionListener;
import com.twu.biblioteca.model.Option;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.welcomeMessage();

        Menu menu = new Menu();
        menu.addOption(new Option(1, "List Books"));
        menu.addOption(new Option(2, "Quit"));
        menu.setListener(new OptionListener() {
            @Override
            public void onOptionSelected(Option option) {
                if (option != null) {
                    switch (option.getId()) {
                        case 1:
                            Catalogue catalogue = new Catalogue();
                            catalogue.showBookList(catalogue.createBookList());
                            break;
                    }
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
