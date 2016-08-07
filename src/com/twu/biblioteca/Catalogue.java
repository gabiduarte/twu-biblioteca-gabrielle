package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;


public class Catalogue {

    public void showBookList(List<Book> books) {
        if (books.size() > 0 ) {
            System.out.println("\n***** Books Available *****\n(BOOK | AUTHOR | YEAR)\n");
            for (int i = 0; i < books.size(); i++) {
                Book currentBook = books.get(i);
                String currentBookYear = Integer.toString(currentBook.getYear());
                String output = currentBook.getName() + " | " + currentBook.getAuthor() + " | " + currentBookYear;

                System.out.println(output);
            }
        } else {
            System.out.println("No books available");
        }
    }

    public List<Book> createBookList() {
        List<Book> books = new ArrayList<Book>();

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

        return books;
    }

}
