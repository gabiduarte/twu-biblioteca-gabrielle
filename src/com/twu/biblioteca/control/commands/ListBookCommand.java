package com.twu.biblioteca.control.commands;

import com.twu.biblioteca.constants.Message;
import com.twu.biblioteca.control.BookCatalogue;
import com.twu.biblioteca.model.Book;

import java.util.List;


public class ListBookCommand implements Command {
    BookCatalogue bookCatalogue;

    public ListBookCommand(BookCatalogue bookCatalogue) {
        this.bookCatalogue = bookCatalogue;
    }

    public void execute() {
        listBooks();
    }

    public void listBooks() {
        List<Book> books = bookCatalogue.retrieveSelectedList(bookCatalogue.getBookList(), true);

        if (books != null) {
            System.out.println(Message.BOOKS_AVAILABLE);
            System.out.println(Message.BOOK_COLUMNS);

            for (Book book: books) {
                String bookInfo = String.format(Message.BOOK_FORMAT, book.getId(), book.getName(), book.getYear());
                System.out.println(bookInfo);
            }
        } else {
            System.out.println(Message.NO_BOOKS);
        }
    }
}
