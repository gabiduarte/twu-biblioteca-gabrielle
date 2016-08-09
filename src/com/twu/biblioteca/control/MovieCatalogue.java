package com.twu.biblioteca.control;


import com.twu.biblioteca.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieCatalogue {
    private List<Movie> movies = new ArrayList<Movie>();

//    public void createMovieList() {
//        Movie movie1 = new Movie("Kiki's Delivery Service", 1989, "Hayao Miyazaki", 9);
//        Movie movie2 = new Movie("Howl's Moving Castle", 2004, "Hayao Miyazaki", 0);
//    }

    public void showList(List<Movie> movies, boolean showAvailable) {
        if (movies.size() > 0 ) {
            System.out.println("\n***** MOVIES Available *****\n(ID | MOVIE | DIRECTOR | YEAR)\n");
            for (int i = 0; i < movies.size(); i++) {
                Movie currentMovie = movies.get(i);

                if (showAvailable) {
                    if (currentMovie.isCheckedOut()) continue;
                } else {
                    if (!currentMovie.isCheckedOut()) continue;
                }

                String currentMovieID = Integer.toString(currentMovie.getId());
                String currentMovieYear = Integer.toString(currentMovie.getYear());
                String output = currentMovieID + " | " + currentMovie.getName() + " | " + currentMovie.getDirector() + " | " + currentMovieYear;
                System.out.println(output);
            }
        } else {
            System.out.println("No books available");
        }
    }
}
