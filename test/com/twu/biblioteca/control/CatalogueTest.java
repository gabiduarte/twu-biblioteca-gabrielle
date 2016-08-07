package com.twu.biblioteca.control;

import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CatalogueTest {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private List<Book> books = new ArrayList<Book>();
    private List<Book> emptyBookList = new ArrayList<Book>();
    private Catalogue catalogue = new Catalogue();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));

        Book book1 = new Book();
        book1.setBookID(1);
        book1.setName("Harry Potter and the Cursed Child");
        book1.setAuthor("JK Rowling");
        book1.setYear(2016);
        book1.setCheckedOut(false);
        books.add(book1);

        Book book2 = new Book();
        book2.setBookID(2);
        book2.setName("Mockingjay");
        book2.setAuthor("Suzanne Collins");
        book2.setYear(2010);
        book2.setCheckedOut(true);
        books.add(book2);

        catalogue.createBookList();
    }

    @Test
    public void shouldshowListOfBooksAvailable() {
        catalogue.showAvailableBookList(books);

        String expectedString = "\n***** Books Available *****\n" +
                "(ID | BOOK | AUTHOR | YEAR)\n\n" +
                "1 | Harry Potter and the Cursed Child | JK Rowling | 2016\n";

        assertEquals(expectedString, outContent.toString());
    }

    @Test
    public void showMessageIfBookListIsEmpty() {
        Catalogue catalogue = new Catalogue();
        catalogue.showAvailableBookList(emptyBookList);

        assertEquals("No books available\n", outContent.toString());
    }

    @Test
    public void shouldCheckOutBookSuccessfully() {
        Book book = books.get(0);
        catalogue.checkOutBook(book);
        boolean expectedCheckedOutValueAfterSuccess = true;

        assertTrue(expectedCheckedOutValueAfterSuccess == book.isCheckedOut());
        assertEquals("Thank you! Enjoy the book\n", outContent.toString());
    }

    @Test
    public void shouldShowUnsuccessfulMessageIfBookIsCheckedOut() {
        Book book = books.get(1);
        catalogue.checkOutBook(book);

        assertEquals("That book is not available.\n", outContent.toString());
    }

    @Test
    public void shouldReturnNullIfBookIDDoesntMatch() {
        String book = books.get(0).getName();
        assertEquals(book, catalogue.checkIfBookExistsInList(1).getName());
        assertNull(catalogue.checkIfBookExistsInList(393));
    }
}