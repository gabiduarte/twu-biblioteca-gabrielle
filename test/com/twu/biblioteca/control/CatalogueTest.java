package com.twu.biblioteca.control;

import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CatalogueTest {
    private List<Book> books = new ArrayList<Book>();
    private List<Movie> movies = new ArrayList<Movie>();
    private List<Book> availableBooks = new ArrayList<Book>();
    private List<Movie> unavailableMovies = new ArrayList<Movie>();
    private List<Book> emptyBookList = new ArrayList<Book>();

    private BookCatalogue bookCatalogue = new BookCatalogue();
    private MovieCatalogue movieCatalogue = new MovieCatalogue();

    @Before
    public void setup() {
        Book book1 = new Book();
        book1.setId(1);
        book1.setName("Harry Potter and the Cursed Child");
        book1.setAuthor("JK Rowling");
        book1.setYear(2016);
        book1.setCheckedOut(false);
        books.add(book1);
        availableBooks.add(book1);

        Book book2 = new Book();
        book2.setId(2);
        book2.setName("Mockingjay");
        book2.setAuthor("Suzanne Collins");
        book2.setYear(2010);
        book2.setCheckedOut(true);
        books.add(book2);

        Movie movie1 = new Movie("Titanic", 1997, "James Cameron", 0);
        Movie movie2 = new Movie("Spirited Away", 2001, "Hayao Miyazaki", 10);
        movie1.setCheckedOut(true);
        unavailableMovies.add(movie1);
        movies.add(movie1);
        movies.add(movie2);

        bookCatalogue.createBookList();
        movieCatalogue.createMovieList();
    }

    @Test
    public void shouldReturnListOfMediaIfAvailableOrNot() {
        List<Book> selectedAvailableBooks = bookCatalogue.retrieveSelectedList(books, true);
        List<Movie> selectedUnavailableMovies = movieCatalogue.retrieveSelectedList(movies, false);

        assertTrue(selectedAvailableBooks.get(0) == availableBooks.get(0));
        assertTrue(selectedUnavailableMovies.get(0) == unavailableMovies.get(0));
    }

    @Test
    public void shouldReturnNullIfNoMediaAvailable() {
        List<Book> nullList = bookCatalogue.retrieveSelectedList(emptyBookList, true);
        assertNull(nullList);
    }

    @Test
    public void shouldCheckOutMediaSuccessfully() {
        Book book = books.get(0);
        assertFalse(book.isCheckedOut());

        bookCatalogue.changeStatus(book, true, "Book");
        assertTrue(book.isCheckedOut());
    }

    @Test
    public void shouldReturnUnsuccessfulMessageIfMediaIsAlreadyCheckedOut() {
        Book book = books.get(1);
        String bookStatus = bookCatalogue.changeStatus(book, true, "Book");

        assertEquals("That Book is not available", bookStatus);
    }

    @Test
    public void shouldReturnNullIfMediaIDDoesntMatch() {
        String book = books.get(0).getName();
        assertEquals(book, bookCatalogue.selectMedia(books, 1).getName());
        assertNull(bookCatalogue.selectMedia(books, 393));
    }

    @Test
    public void shouldReturnMediaSuccessfully() {
        Book book = books.get(1);
        assertTrue(book.isCheckedOut());

        bookCatalogue.changeStatus(book, false, "Book");
        assertFalse(book.isCheckedOut());
    }

    @Test
    public void shouldShowUnsuccessfulMessageIfMediaIsAlreadyReturned() {
        Book book = books.get(0);
        String bookStatus = bookCatalogue.changeStatus(book, false, "Book");

        assertEquals("That is not a valid Book to return", bookStatus);
    }
}