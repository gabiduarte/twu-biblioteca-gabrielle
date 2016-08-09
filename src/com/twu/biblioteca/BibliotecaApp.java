package com.twu.biblioteca;


import com.twu.biblioteca.control.BookCatalogue;
import com.twu.biblioteca.control.Menu;
import com.twu.biblioteca.control.MovieCatalogue;
import com.twu.biblioteca.misc.OptionListener;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
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
        menu.addOption(new Option(3, "Return Book"));
        menu.addOption(new Option(4, "List Movies"));
        menu.addOption(new Option(5, "Checkout Movie"));
        menu.addOption(new Option(6, "Quit"));

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
                            List<Book> books = bookCatalogue.retrieveSelectedList(bookCatalogue.getBookList(), true);

                            if (books != null) {
                                System.out.println("**** Books Available ****");

                                for (Book book: books) {
                                    String bookId = Integer.toString(book.getId());
                                    String bookYear = Integer.toString(book.getYear());

                                    String output = bookId + " | " + book.getName() + " | " + book.getAuthor() + " | " + bookYear;
                                    System.out.println(output);
                                }
                            } else {
                                System.out.println("No books available");
                            }
                            break;
                        case 2:
                        case 3:
                            boolean isCheckingOut = (option.getId() == 2);
                            books = bookCatalogue.retrieveSelectedList(bookCatalogue.getBookList(), isCheckingOut);

                            String instruction = isCheckingOut ? "Enter the ID of the Book you want to Checkout" : "Enter the ID of the book you want to return";
                            System.out.println(instruction);

                            Scanner scanner = new Scanner(System.in);
                            int bookChosen = scanner.nextInt();

                            Book validatedBookChosen = bookCatalogue.selectMedia(books, bookChosen);

                            String bookStatus = (validatedBookChosen != null) ? bookCatalogue.changeStatus(validatedBookChosen, isCheckingOut, "Book") :  "No book found with this ID";
                            System.out.println(bookStatus);
                            break;
                        case 4:
                            List<Movie> movies = movieCatalogue.retrieveSelectedList(movieCatalogue.getMovieList(), true);

                            if (movies != null) {
                                System.out.println("*** Movies Available ***");

                                for (Movie movie: movies) {
                                    String movieId = Integer.toString(movie.getId());
                                    String movieYear = Integer.toString(movie.getYear());
                                    String output = movieId + " | " + movie.getName() + " | " + movie.getDirector()
                                            +  " | " + movieYear + " | " + movie.getRating();

                                    System.out.println(output);
                                }
                            } else {
                                System.out.println("No movies available");
                            }
                            break;

                        case 5:
                            isCheckingOut = true;
                            List<Movie> selectedMovies = movieCatalogue.retrieveSelectedList(movieCatalogue.getMovieList(), true);
                            System.out.println("Enter the ID of the Movie you want to Checkout:");

                            scanner = new Scanner(System.in);
                            int movieChosen = scanner.nextInt();

                            Movie validMovieChosen = movieCatalogue.selectMedia(selectedMovies, movieChosen);

                            String movieStatus = (validMovieChosen != null) ? movieCatalogue.changeStatus(validMovieChosen, isCheckingOut, "Movie") :  "No movie found with this ID";
                            System.out.println(movieStatus);
                            break;
                        case 6:
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
                System.out.println("Choose option from menu:");
                Scanner scanner = new Scanner(System.in);
                int userOption = scanner.nextInt();
                sentOptionToListener = menu.getUserOption(userOption);

                if (userOption == 6) quitMenu = true;
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
