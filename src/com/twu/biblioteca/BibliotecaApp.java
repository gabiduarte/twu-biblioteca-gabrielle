package com.twu.biblioteca;


import com.twu.biblioteca.control.Catalogue;
import com.twu.biblioteca.control.Menu;
import com.twu.biblioteca.misc.OptionListener;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Option;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.welcomeMessage();

        Menu menu = new Menu();
        menu.addOption(new Option(1, "List Books"));
        menu.addOption(new Option(2, "Checkout Book"));
        menu.addOption(new Option(3, "Quit"));

        final Catalogue catalogue = new Catalogue();
        catalogue.createBookList();

        menu.setListener(new OptionListener() {
            @Override
            public void onOptionSelected(Option option) {
                if (option != null) {
                    switch (option.getId()) {
                        case 1:
                            catalogue.showAvailableBookList(catalogue.getBookList());
                            break;
                        case 2:
                            System.out.println("Choose the book you want to checkout by ID");
                            catalogue.showAvailableBookList(catalogue.getBookList());

                            Scanner scanner = new Scanner(System.in);
                            int bookChosen = scanner.nextInt();

                            Book validatedBookChosen = catalogue.checkIfBookExistsInList(bookChosen);

                            if (validatedBookChosen != null) {
                                catalogue.checkOutBook(validatedBookChosen);
                            } else {
                                System.out.println("No book found with this ID");
                            }
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
