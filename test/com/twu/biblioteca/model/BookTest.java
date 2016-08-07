package com.twu.biblioteca.model;

import com.twu.biblioteca.model.Book;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {
    private Book book = new Book();

    @Before
    public void setup() {
        book.setName("Harry Potter and the Cursed Child");
        book.setAuthor("JK Rowling");
        book.setYear(2016);
    }

    @Test
    public void getBookName(){
        assertEquals("Harry Potter and the Cursed Child", book.getName());
    }

    @Test
    public void getBookYear() {
        assertEquals(2016, book.getYear());
    }

    @Test
    public void getBookAuthor() { assertEquals("JK Rowling", book.getAuthor());}

}
