package com.twu.biblioteca.menu;

import com.twu.biblioteca.main.BibliotecaApp;
import com.twu.biblioteca.util.AppState;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainMenuTest {

    private BibliotecaApp bibApp;
    private MainMenu menu;

    @Before
    public void initialize() {
        bibApp = new BibliotecaApp();
        menu = new MainMenu(bibApp.console);
    }

    @Test
    public void processInput_shouldGoToRentMenu_WhenInputIs1() {
        assertEquals(AppState.CHEKOUT_BOOK_MENU, menu.processInput("1"));
    }

    @Test
    public void processInput_shouldGoToReturnMenu_WhenInputIs2() {

        assertEquals(AppState.RETURN_BOOK_MENU, menu.processInput("2"));
    }

    @Test
    public void processInput_shouldGoToRentVideoMenu_WhenInputIs3() {
        assertEquals(AppState.CHEKOUT_VIDEO_MENU, menu.processInput("3"));
    }

    @Test
    public void processInput_shouldQuit_WhenInputIs4() {
        assertEquals(AppState.QUIT, menu.processInput("5"));
    }

    @Test
    public void isValidInput_shouldReturnTrue_GivenValidInput() {
        String input = "1";
        assertTrue(menu.isValidInput(input));
    }

    @Test
    public void isValidInput_shouldReturnFalse_GivenInputWithTooHighNumber() {
        String input = "7";
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