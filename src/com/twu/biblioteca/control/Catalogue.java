package com.twu.biblioteca.control;

import com.twu.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;


public class Catalogue {

    public void showAvailableBookList(List<Book> books) {
        if (books.size() > 0 ) {
            System.out.println("\n***** Books Available *****\n(ID | BOOK | AUTHOR | YEAR)\n");
            for (int i = 0; i < books.size(); i++) {
                Book currentBook = books.get(i);
                if (currentBook.isCheckedOut()) break;
                String currentBookID = Integer.toString(currentBook.getBookID());
                String currentBookYear = Integer.toString(currentBook.getYear());
                String output = currentBookID + " | " + currentBook.getName() + " | " + currentBook.getAuthor() + " | " + currentBookYear;

                System.out.println(output);
            }
        } else {
            System.out.println("No books available");
        }
    }

    public void checkOutBook(Book book) {
        if (!book.isCheckedOut()) {
            book.setCheckedOut(true);
            System.out.println("Thank you! Enjoy the book");
        } else {
            System.out.println("That book is not available.");
        }
    }
    public List<Book> getBookList() {
        List<Book> books = new ArrayList<Book>();

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

        return books;
    }

}
