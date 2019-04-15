package com.twu.biblioteca.main;


import com.twu.biblioteca.main.BibliotecaApp;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    private BibliotecaApp bibApp;

    @Before
    public void initialize() {
        bibApp = new BibliotecaApp();
    }

    @Test
    public void showWelcomeMessageTest() {
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", bibApp.showWelcomeMessage());
    }
}
