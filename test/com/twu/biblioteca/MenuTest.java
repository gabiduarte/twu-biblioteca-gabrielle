package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class MenuTest {
    Menu menu = new Menu();

    @Test
    public void addOption() {
        Option option = new Option(01, "List Books");
        menu.addOption(option);
        assertEquals(option, menu.getOptionList().get(0));
    }

}