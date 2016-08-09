package com.twu.biblioteca.control;

import com.twu.biblioteca.model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class MovieCatalogueTest {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private MovieCatalogue movieCatalogue = new MovieCatalogue();
    private List<Movie> movies = new ArrayList<Movie>();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
        Movie movie1 = new Movie("Titanic", 1997, "James Cameron", 0);
        Movie movie2 = new Movie("Spirited Away", 2001, "Hayao Miyazaki", 10);

        movies.add(movie1);
        movies.add(movie2);
    }

    @Test
    public void shouldShowAllMoviesAvailable() {
        movieCatalogue.showList(movies, true);
        String expectedReturn = "\n***** MOVIES Available *****\n" +
                "(ID | MOVIE | DIRECTOR | YEAR)\n" +
                "\n0 | Titanic | James Cameron | 1997\n" +
                "0 | Spirited Away | Hayao Miyazaki | 2001\n";

        assertEquals(expectedReturn, outContent.toString());
    }
}