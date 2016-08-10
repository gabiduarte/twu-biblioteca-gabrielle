package com.twu.biblioteca;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.twu.biblioteca.model.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BibliotecaAppTest {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    BibliotecaApp biblioteca = new BibliotecaApp();

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }
    @Test
    public void shouldShowWelcomeMessage() {
        String expectedOutput = "Welcome to Biblioteca! Everything is up and running!\n";
        biblioteca.welcomeMessage();
        assertEquals(expectedOutput, outContent.toString());
    }
}