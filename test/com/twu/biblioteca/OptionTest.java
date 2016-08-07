package com.twu.biblioteca;

import com.twu.biblioteca.model.Option;
import org.junit.Test;
import static org.junit.Assert.*;

public class OptionTest {
    Option option = new Option(01, "List Books");

    @Test
    public void getOptionName() {
        assertEquals("List Books", option.getName());
    }

    @Test
    public void getOptionID() {
        assertEquals(01, option.getId());
    }
}