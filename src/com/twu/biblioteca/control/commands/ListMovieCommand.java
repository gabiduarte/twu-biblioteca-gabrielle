package com.twu.biblioteca.control.commands;


import com.twu.biblioteca.constants.Message;
import com.twu.biblioteca.control.MovieCatalogue;
import com.twu.biblioteca.model.Movie;

import java.util.List;

public class ListMovieCommand implements Command  {
    MovieCatalogue movieCatalogue;

    public ListMovieCommand(MovieCatalogue movieCatalogue) {
        this.movieCatalogue = movieCatalogue;
    }

    public void execute() {
        listMovie();
    }

    public void listMovie() {
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
}
