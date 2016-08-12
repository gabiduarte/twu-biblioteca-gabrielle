package com.twu.biblioteca;


import com.twu.biblioteca.constants.Message;
import com.twu.biblioteca.control.BookCatalogue;
import com.twu.biblioteca.control.Menu;
import com.twu.biblioteca.control.MovieCatalogue;
import com.twu.biblioteca.control.UserController;
import com.twu.biblioteca.misc.OptionListener;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.Option;
import com.twu.biblioteca.model.User;

import java.util.InputMismatchException;
import java.util.List;
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
        menu.addOption(new Option(1, "List Books"));
        menu.addOption(new Option(2, "Checkout Book"));
        menu.addOption(new Option(3, "Return Book"));
        menu.addOption(new Option(4, "List Movies"));
        menu.addOption(new Option(5, "Checkout Movie"));
        menu.addOption(new Option(6, "See Profile"));
        menu.addOption(new Option(7, "Quit"));


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
                            biblioteca.listBooks(bookCatalogue);
                            break;
                        case 2:
                            biblioteca.changeStatusOfBook(bookCatalogue, true);
                            break;
                        case 3:
                            biblioteca.changeStatusOfBook(bookCatalogue, false);
                            break;
                        case 4:
                            biblioteca.listMovies(movieCatalogue);
                            break;
                        case 5:
                            biblioteca.checkOutMovie(movieCatalogue);
                            break;
                        case 6:
                            biblioteca.viewProfile();
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

    public void listBooks(BookCatalogue bookCatalogue) {
        List<Book> books = bookCatalogue.retrieveSelectedList(bookCatalogue.getBookList(), true);

        if (books != null) {
            System.out.println(Message.BOOKS_AVAILABLE);
            System.out.println(Message.BOOK_COLUMNS);

            for (Book book: books) {
                String bookInfo = String.format(Message.BOOK_FORMAT, book.getId(), book.getName(), book.getYear());
                System.out.println(bookInfo);
            }
        } else {
            System.out.println(Message.NO_BOOKS);
        }
    }

    public void changeStatusOfBook(BookCatalogue bookCatalogue, boolean checkOut) {
        boolean isCheckingOut = checkOut;
        List<Book> books = bookCatalogue.retrieveSelectedList(bookCatalogue.getBookList(), isCheckingOut);

        String instruction = isCheckingOut ? Message.CHECKOUT_BOOK_ID : Message.RETURN_BOOK_ID;
        System.out.println(instruction);

        Scanner scanner = new Scanner(System.in);
        int bookChosen = scanner.nextInt();

        Book validatedBookChosen = bookCatalogue.selectMedia(books, bookChosen);

        String bookStatus = (validatedBookChosen != null) ? bookCatalogue.changeStatus(validatedBookChosen, isCheckingOut, "Book") :  Message.NO_BOOK_FOUND;
        System.out.println(bookStatus);
    }

    public void listMovies(MovieCatalogue movieCatalogue) {
        List<Movie> movies = movieCatalogue.retrieveSelectedList(movieCatalogue.getMovieList(), true);

        if (movies != null) {
            System.out.println(Message.MOVIES_AVAILABLE);
            System.out.println(Message.MOVIE_COLUMNS);

            for (Movie movie: movies) {
                String movieInfo = String.format(Message.MOVIE_FORMAT, movie.getId(), movie.getName(), movie.getDirector(), movie.getYear(), movie.getRating());
                System.out.println(movieInfo);
            }
        } else {
            System.out.println(Message.NO_MOVIES);
        }
    }

    public void checkOutMovie(MovieCatalogue movieCatalogue) {
        List<Movie> selectedMovies = movieCatalogue.retrieveSelectedList(movieCatalogue.getMovieList(), true);
        System.out.println(Message.INSERT_MOVIE_ID);

        Scanner scanner = new Scanner(System.in);
        int movieChosen = scanner.nextInt();

        Movie validMovieChosen = movieCatalogue.selectMedia(selectedMovies, movieChosen);

        String movieStatus = (validMovieChosen != null) ? movieCatalogue.changeStatus(validMovieChosen, true, "Movie") :  Message.NO_MOVIE_FOUND;
        System.out.println(movieStatus);
    }

    public void viewProfile() {
        System.out.println(Message.VIEW_PROFILE);
        String userInformation = String.format(Message.PROFILE_FORMAT, currentUser.getName(), currentUser.getEmail(), currentUser.getPhone());
        System.out.println(userInformation);
    }
}