package com.twu.biblioteca;


import com.twu.biblioteca.control.Catalogue;
import com.twu.biblioteca.control.Menu;
import com.twu.biblioteca.misc.OptionListener;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Option;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.welcomeMessage();

        Menu menu = new Menu();
        menu.addOption(new Option(1, "List Books"));
        menu.addOption(new Option(2, "Checkout Book"));
        menu.addOption(new Option(3, "Return Book"));
        menu.addOption(new Option(4, "Quit"));

        final Catalogue catalogue = new Catalogue();
        catalogue.createBookList();

        menu.setListener(new OptionListener() {
            @Override
            public void onOptionSelected(Option option) {
                if (option != null) {
                    switch (option.getId()) {
                        case 1:
                            catalogue.showBookList(catalogue.getBookList(), true);
                            break;
                        case 2:
                        case 3:
                            boolean isCheckingOut = (option.getId() == 2);
                            String instruction = isCheckingOut ? "Choose the book you want to checkout by ID" : "Choose the book you want to return by ID";

                            System.out.println(instruction);
                            catalogue.showBookList(catalogue.getBookList(), isCheckingOut);

                            Scanner scanner = new Scanner(System.in);
                            int bookChosen = scanner.nextInt();

                            Book validatedBookChosen = catalogue.checkIfBookExistsInList(bookChosen);

                            if (validatedBookChosen != null) {
                                catalogue.manipulateBook(validatedBookChosen, isCheckingOut);
                            } else {
                                System.out.println("No book found with this ID");
                            }
                            break;
                        case 4:
                            System.out.println("Thanks for using Biblioteca");
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

                if (userOption == 4) quitMenu = true;
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
