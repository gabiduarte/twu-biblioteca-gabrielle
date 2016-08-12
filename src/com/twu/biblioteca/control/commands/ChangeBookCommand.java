package com.twu.biblioteca.control.commands;


import com.twu.biblioteca.constants.Message;
import com.twu.biblioteca.control.BookCatalogue;
import com.twu.biblioteca.model.Book;

import java.util.List;
import java.util.Scanner;

public class ChangeBookCommand implements Command {
    BookCatalogue bookCatalogue;
    boolean isCheckingOut;

    public ChangeBookCommand(BookCatalogue bookCatalogue, boolean checkOut) {
        this.bookCatalogue = bookCatalogue;
        this.isCheckingOut = checkOut;
    }

    public void execute() {
        changeBook(bookCatalogue, isCheckingOut);
    }

    public void changeBook(BookCatalogue bookCatalogue, boolean checkOut) {
        isCheckingOut = checkOut;
        List<Book> books = bookCatalogue.retrieveSelectedList(bookCatalogue.getBookList(), isCheckingOut);

        String instruction = isCheckingOut ? Message.CHECKOUT_BOOK_ID : Message.RETURN_BOOK_ID;
        System.out.println(instruction);

        Scanner scanner = new Scanner(System.in);
        int bookChosen = scanner.nextInt();

        Book validatedBookChosen = bookCatalogue.selectMedia(books, bookChosen);

        String bookStatus = (validatedBookChosen != null) ? bookCatalogue.changeStatus(validatedBookChosen, isCheckingOut, "Book") : Message.NO_BOOK_FOUND;
        System.out.println(bookStatus);
    }
}
