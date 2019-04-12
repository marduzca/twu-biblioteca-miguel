package com.twu.biblioteca.menu;

import com.twu.biblioteca.main.BibliotecaApp;
import com.twu.biblioteca.util.AppState;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainMenuTest {

    private MainMenu menu;

    @Before
    public void initialize() {
        menu = new MainMenu();
    }

    @Test
    public void processInput_shouldGoToRentMenu_WhenInputIs1() {
        menu.processInput("1");
        assertEquals(AppState.CHEKOUT_BOOK_MENU, BibliotecaApp.currentState);
    }

    @Test
    public void processInput_shouldGoToReturnMenu_WhenInputIs2() {
        menu.processInput("2");
        assertEquals(AppState.RETURN_BOOK_MENU, BibliotecaApp.currentState);
    }

    @Test
    public void processInput_shouldQuit_WhenInputIs3() {
        menu.processInput("3");
        assertEquals(AppState.QUIT, BibliotecaApp.currentState);
    }

    @Test
    public void isValidInput_shouldReturnTrue_GivenValidInput() {
        String input = "1";
        assertTrue(menu.isValidInput(input));
    }

    @Test
    public void isValidInput_shouldReturnFalse_GivenInputWithTooHighNumber() {
        String input = "4";
        assertFalse(menu.isValidInput(input));
    }

    @Test
    public void isValidInput_shouldReturnFalse_GivenInputNull() {
        String input = null;
        assertFalse(menu.isValidInput(input));
    }

    @Test
    public void isValidInput_shouldReturnFalse_GivenInputEmpty() {
        String input = "";
        assertFalse(menu.isValidInput(input));
    }

    @Test
    public void isValidInput_shouldReturnFalse_GivenInputNotNumeric() {
        String input = "xzy";
        assertFalse(menu.isValidInput(input));
    }
}