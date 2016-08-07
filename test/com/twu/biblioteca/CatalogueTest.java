package com.twu.biblioteca;

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

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));

        Book book1 = new Book();
        book1.setName("Harry Potter and the Cursed Child");
        book1.setAuthor("JK Rowling");
        book1.setYear(2016);
        books.add(book1);

        Book book2 = new Book();
        book2.setName("Mockingjay");
        book2.setAuthor("Suzanne Collins");
        book2.setYear(2010);
        books.add(book2);
    }

    @Test
    public void showListOfBooks() {
        Catalogue catalogue = new Catalogue();
        catalogue.showBookList(books);

        String expectedString = "\n***** Books Available *****\n" +
                "(BOOK | AUTHOR | YEAR)\n\n" +
                "Harry Potter and the Cursed Child | JK Rowling | 2016\n" +
                "Mockingjay | Suzanne Collins | 2010\n";

        assertEquals(expectedString, outContent.toString());
    }

    @Test
    public void showMessageIfBookListIsEmpty() {
        Catalogue catalogue = new Catalogue();
        catalogue.showBookList(emptyBookList);

        assertEquals("No books available\n", outContent.toString());
    }
}