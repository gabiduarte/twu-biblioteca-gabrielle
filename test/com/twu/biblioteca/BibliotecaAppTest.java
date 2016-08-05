package com.twu.biblioteca;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;




import static org.junit.Assert.*;

public class BibliotecaAppTest {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testWelcomeMessage() {
        String expectedOutput = "Welcome to Biblioteca! Everything is up and running!\n";
        BibliotecaApp biblioteca = new BibliotecaApp();
        biblioteca.welcomeMessage();
        assertEquals(expectedOutput, outContent.toString());
    }

}