package com.twu.biblioteca.control.commands;


import com.twu.biblioteca.constants.Message;
import com.twu.biblioteca.control.MovieCatalogue;
import com.twu.biblioteca.model.Movie;

import java.util.List;
import java.util.Scanner;

public class CheckoutMovieCommand implements Command{
    MovieCatalogue movieCatalogue;

    public CheckoutMovieCommand(MovieCatalogue movieCatalogue) {
        this.movieCatalogue = movieCatalogue;
    }

    public void execute() {
        checkoutMovie();
    }

    public void checkoutMovie() {
        List<Movie> selectedMovies = movieCatalogue.retrieveSelectedList(movieCatalogue.getMovieList(), true);
        System.out.println(Message.INSERT_MOVIE_ID);

        Scanner scanner = new Scanner(System.in);
        int movieChosen = scanner.nextInt();

        Movie validMovieChosen = movieCatalogue.selectMedia(selectedMovies, movieChosen);

        String movieStatus = (validMovieChosen != null) ? movieCatalogue.changeStatus(validMovieChosen, true, "Movie") :  Message.NO_MOVIE_FOUND;
        System.out.println(movieStatus);
    }
}
