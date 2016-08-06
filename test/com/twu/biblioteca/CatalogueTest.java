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

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));

        Book book1 = new Book();
        book1.setName("Harry Potter and the Cursed Child");
        books.add(book1);

        Book book2 = new Book();
        book2.setName("Mockingjay");
        books.add(book2);
    }

    @Test
    public void showListOfBooks() {
        Catalogue catalogue = new Catalogue();
        catalogue.showBookList(books);
        assertEquals("\nBooks Available:\nHarry Potter and the Cursed Child\nMockingjay\n", outContent.toString());
    }
}