package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {
    private Book book = new Book();

    @Before
    public void setup() {
        book.setName("Harry Potter and the Cursed Child");
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

}
