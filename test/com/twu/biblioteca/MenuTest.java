package com.twu.biblioteca;

import com.twu.biblioteca.control.Menu;
import com.twu.biblioteca.model.Option;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MenuTest {
    Menu menu = new Menu();
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldAddOption() {
        Option option = new Option(01, "List Books");
        menu.addOption(option);
        assertEquals(option, menu.getOptionList().get(0));
    }

    @Test
    public void shouldShowMessageWithoutOptionList() {
        String expectedMessage = "\n** Biblioteca Menu - No options available\n";
        menu.showOptions();

        assertEquals(expectedMessage, outContent.toString());
    }

    @Test
    public void shouldGetUserOption() {
        //
    }
}