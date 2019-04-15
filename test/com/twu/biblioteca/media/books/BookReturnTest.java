package com.twu.biblioteca.media.books;

import com.twu.biblioteca.accounts.LoginManager;
import com.twu.biblioteca.main.BibliotecaApp;
import com.twu.biblioteca.util.AppState;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookReturnTest {

    private BibliotecaApp bibApp;
    private BookReturn bookReturn;
    private BookManager bookManager;
    private LoginManager loginManager;

    @Before
    public void initialize()  {
        bibApp = new BibliotecaApp();
        loginManager = new LoginManager(bibApp.console);
        bibApp.currentAccount = loginManager.getAccountsList().get(0);
        bookManager = new BookManager();
        bookReturn = new BookReturn(bibApp, bookManager, bibApp.console);
    }

    @Test
    public void returnBookTest_shouldBeAvailable_WhenReturnSuccessful(){
        bookManager.getBookList().get(0).setAvailability(false);
        bookReturn.returnBook(101);

        assertTrue(bookManager.getBookList().get(0).isAvailable());
    }

    @Test
    public void returnBookTest_shouldGoBackToMainMenu_WhenReturnSuccessful(){
        bookManager.getBookList().get(0).setAvailability(false);

        assertEquals(AppState.MAIN_MENU, bookReturn.returnBook(101));    }

    @Test
    public void returnBookTest_shouldStayInReturnBookMenu_WhenIdIsInvalid(){
            assertEquals(AppState.RETURN_BOOK_MENU, bookReturn.returnBook(101));
    }

    @Test
    public void returnBookTest_shouldStayInReturnBookMenu_WhenInputIdNotExistent(){
        assertEquals(AppState.RETURN_BOOK_MENU, bookReturn.returnBook(0));
    }
}