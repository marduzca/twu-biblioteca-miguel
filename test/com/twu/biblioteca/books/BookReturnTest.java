package com.twu.biblioteca.books;

import com.twu.biblioteca.main.BibliotecaApp;
import com.twu.biblioteca.util.AppState;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookReturnTest {

    private BookReturn bookReturn;
    private BookManager bookManager;

    @Before
    public void initialize()  {
        bookReturn = new BookReturn();
        bookManager = new BookManager();
    }

    @Test
    public void returnBookTest_shouldGoBackToMainMenu_WhenReturnSuccessful() {
        BookManager.getBookList().get(0).setAvailability(false);
        bookReturn.returnBook(101);

        assertEquals(AppState.MAIN_MENU, BibliotecaApp.currentState);
    }

    @Test
    public void returnBookTest_shouldBeAvailable_WhenReturnSuccessful(){
        BookManager.getBookList().get(0).setAvailability(false);
        bookReturn.returnBook(101);

        assertTrue(BookManager.getBookList().get(0).isAvailable());
    }

    @Test
    public void returnBookTest_shouldShowSuccessMsg_WhenIdIsCorrect(){
        BookManager.getBookList().get(0).setAvailability(false);
        assertEquals("Thank you for returning the book", bookReturn.returnBook(101));    }

    @Test
    public void returnBookTest_shouldShowErrorMsg_WhenIdIsInvalid(){
        assertEquals("That is not a valid book to return", bookReturn.returnBook(101));
    }

    @Test
    public void returnBookTest_shouldShowErrorMsg_WhenInputIdNotExistent(){
        assertEquals("That is not a valid book to return", bookReturn.returnBook(0));
    }
}