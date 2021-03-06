package com.twu.biblioteca.constants;


public class Message {
    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca! Everything is up and running!";
    public static final String LOGIN_MESSAGE = "Enter your Library Number to continue:";
    public static final String ASK_PASSWORD = "Please insert your password:";
    public static final String WRONG_PASSWORD = "Wrong password.";
    public static final String WRONG_LIBRARY_NUMBER = "Wrong Library Number.";
    public static final String INSERT_NUMBER = "Please insert numbers only.";
    public static final String INSERT_VALID_OPTION = "Please insert a valid option number.";
    public static final String CHOOSE_OPTION = "Choose option from menu:";
    public static final String QUIT_MESSAGE = "Thanks for using Biblioteca.";
    public static final String INSERT_MOVIE_ID = "Enter the ID of the Movie you want to Checkout:";
    public static final String NO_MOVIES = "No movies available.";
    public static final String MOVIES_AVAILABLE = "***** MOVIES AVAILABLE *****";
    public static final String NO_BOOK_FOUND = "No book found with this ID.";
    public static final String NO_MOVIE_FOUND = "No movie found with this ID.";
    public static final String NO_BOOKS = "No books available.";
    public static final String CHECKOUT_BOOK_ID = "Enter the ID of the Book you want to Checkout.";
    public static final String RETURN_BOOK_ID = "Enter the ID of the book you want to return.";
    public static final String BOOKS_AVAILABLE = "***** BOOKS AVAILABLE *****";
    public static final String VIEW_PROFILE = "***** VIEW MY PROFILE *****";
    public static final String CHECKOUT_SUCCESSFUL = "Thank you! Enjoy your %s.";
    public static final String CHECKOUT_UNSUCCESSFUL = "That %s is not available.";
    public static final String RETURN_SUCCESSFUL = "Thank you for returning your %s.";
    public static final String RETURN_UNSUCCESSFUL = "That is not a valid %s to return.";
    public static final String BOOK_COLUMNS = String.format("%-3s | %-35s | %s", "ID", "NAME", "YEAR");
    public static final String MOVIE_COLUMNS = String.format("%-3s | %-30s | %-20s | %s | %s", "ID", "NAME", "DIRECTOR", "YEAR", "RATING");
    public static final String MOVIE_FORMAT = "%-3d | %-30s | %-20s | %d | %d";
    public static final String BOOK_FORMAT = "%-3d | %-35s | %d";
    public static final String PROFILE_FORMAT = "Name: %s \nE-mail: %s \nPhone: %s";
}
