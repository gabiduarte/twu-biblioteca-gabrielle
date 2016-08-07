package com.twu.biblioteca;


import com.twu.biblioteca.control.Catalogue;
import com.twu.biblioteca.control.Menu;
import com.twu.biblioteca.misc.OptionListener;
import com.twu.biblioteca.model.Option;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.welcomeMessage();

        Menu menu = new Menu();
        menu.addOption(new Option(1, "List Books"));
//        menu.addOption(new Option(2, "Checkout Book"));
        menu.addOption(new Option(3, "Quit"));

        menu.setListener(new OptionListener() {
            @Override
            public void onOptionSelected(Option option) {
                if (option != null) {
                    Catalogue catalogue = new Catalogue();

                    switch (option.getId()) {
                        case 1:
                            catalogue.showAvailableBookList(catalogue.getBookList());
                            break;
                    }
                }
            }
        });

        menu.showOptions();
        boolean sentOptionToListener = false;
        boolean quitMenu = false;

        while (!sentOptionToListener || !quitMenu) {
            try {
                Scanner scanner = new Scanner(System.in);
                int userOption = scanner.nextInt();
                sentOptionToListener = menu.getUserOption(userOption);

                if (userOption == 3) quitMenu = true;
                if (!sentOptionToListener) System.out.println("Please insert a valid option number");

            } catch (InputMismatchException exception) {
                System.out.println("Please insert a number");
            }
        }
    }

    public void welcomeMessage() {
        System.out.println("Welcome to Biblioteca! Everything is up and running!");
    }

}
