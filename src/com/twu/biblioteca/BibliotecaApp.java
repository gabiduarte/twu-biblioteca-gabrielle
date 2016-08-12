package com.twu.biblioteca;


import com.twu.biblioteca.constants.Message;
import com.twu.biblioteca.control.BookCatalogue;
import com.twu.biblioteca.control.Menu;
import com.twu.biblioteca.control.MovieCatalogue;
import com.twu.biblioteca.control.UserController;
import com.twu.biblioteca.control.commands.*;
import com.twu.biblioteca.misc.OptionListener;
import com.twu.biblioteca.model.Option;
import com.twu.biblioteca.model.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaApp {
    private static UserController userController = new UserController();
    private static User currentUser;

    public static void main(String[] args) {
        final BibliotecaApp biblioteca = new BibliotecaApp();
        userController.createUsers();
        biblioteca.login();
        biblioteca.welcomeMessage();

        Menu menu = new Menu();
        menu.createOptions();

        final MovieCatalogue movieCatalogue = new MovieCatalogue();
        final BookCatalogue bookCatalogue = new BookCatalogue();
        movieCatalogue.createMovieList();
        bookCatalogue.createBookList();

        menu.setListener(new OptionListener() {
            @Override
            public void onOptionSelected(Option option) {
                if (option != null) {
                    switch (option.getId()) {
                        case 1:
                            new ListBookCommand(bookCatalogue).execute();
                            break;
                        case 2:
                            new ChangeBookCommand(bookCatalogue, true).execute();
                            break;
                        case 3:
                            new ChangeBookCommand(bookCatalogue, false).execute();
                            break;
                        case 4:
                            new ListMovieCommand(movieCatalogue).execute();
                            break;
                        case 5:
                            new CheckoutMovieCommand(movieCatalogue).execute();
                            break;
                        case 6:
                            new SeeProfileCommand(currentUser).execute();
                            break;
                        case 7:
                            System.out.println(Message.QUIT_MESSAGE);
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
                System.out.println(Message.CHOOSE_OPTION);
                Scanner scanner = new Scanner(System.in);
                int userOption = scanner.nextInt();
                sentOptionToListener = menu.getUserOption(userOption);

                if (userOption == 7) quitMenu = true;
                if (!sentOptionToListener) System.out.println(Message.INSERT_VALID_OPTION);

            } catch (InputMismatchException exception) {
                System.out.println(Message.INSERT_NUMBER);
            }
        }
    }

    public void welcomeMessage() {
        System.out.println(Message.WELCOME_MESSAGE);
    }

    public void login() {
        boolean userLoggedIn = false;

        while(!userLoggedIn) {
            try {
                System.out.println(Message.LOGIN_MESSAGE);
                Scanner scanner = new Scanner(System.in);
                String userNumber = scanner.next();
                User attemptUser = userController.findUser(userNumber);

                if (attemptUser != null) {
                    boolean userPasswordIsCorrect = false;

                    while (!userPasswordIsCorrect) {
                        System.out.println(Message.ASK_PASSWORD);
                        int typedPassword = scanner.nextInt();

                        if (userController.verifyPassword(attemptUser, typedPassword)) {
                            currentUser = attemptUser;
                            userLoggedIn = true;
                            userPasswordIsCorrect = true;
                        } else {
                            System.out.println(Message.WRONG_PASSWORD);
                        }
                    }
                } else {
                    System.out.println(Message.WRONG_LIBRARY_NUMBER);
                }
            } catch (InputMismatchException exception) {
                System.out.println(Message.INSERT_NUMBER);
            }
        }
    }
}