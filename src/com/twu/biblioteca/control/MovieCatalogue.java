package com.twu.biblioteca.control;


import com.twu.biblioteca.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieCatalogue extends Catalogue {
    private List<Movie> movies = new ArrayList<Movie>();

    public void createMovieList() {
        Movie movie1 = new Movie("Kiki's Delivery Service", 1989, "Hayao Miyazaki", 9);
        Movie movie2 = new Movie("Howl's Moving Castle", 2004, "Hayao Miyazaki", 0);
        movie1.setId(1);
        movie2.setId(2);

        movies.add(movie1);
        movies.add(movie2);
    }

    public List<Movie> getMovieList() { return movies; }
}
