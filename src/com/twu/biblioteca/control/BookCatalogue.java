package com.twu.biblioteca.control;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookCatalogue extends Catalogue {
    private static List<Book> books = new ArrayList<Book>();

    public void createBookList() {
        Book book1 = new Book();
        book1.setId(1);
        book1.setName("Harry Potter and the Cursed Child");
        book1.setAuthor("JK Rowling");
        book1.setYear(2016);
        books.add(book1);

        Book book2 = new Book();
        book2.setId(2);
        book2.setName("Mockingjay");
        book2.setAuthor("Suzanne Collins");
        book2.setYear(2010);
        books.add(book2);
    }

    public List<Book> getBookList() { return books; }
}
