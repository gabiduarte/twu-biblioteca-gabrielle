package com.twu.biblioteca.control;

import com.twu.biblioteca.model.Option;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MenuTest {
    private Menu menu = new Menu();
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
    public void shouldValidateOptionInput() {
        Option option1 = new Option(1, "List");
        menu.addOption(option1);
        assertEquals(1, menu.validateUserOption(1));
        assertTrue(menu.validateUserOption(389) == 0);
    }
}