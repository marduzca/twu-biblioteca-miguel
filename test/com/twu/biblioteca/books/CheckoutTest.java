package com.twu.biblioteca.books;

import com.twu.biblioteca.main.BibliotecaApp;
import com.twu.biblioteca.util.AppState;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckoutTest {

    private Checkout bList;
    private BookManager bookManager;

    @Before
    public void initialize () {
        bList = new Checkout();
        bookManager = new BookManager();
    }

    @Test
    public void checkoutBookTest_shouldBeUnavailable_WhenCheckoutSuccessful() {
        BookManager.bookList.get(0).setAvailability(true);
        bList.checkoutBook(101);

        assertEquals(false, BookManager.bookList.get(0).isAvailable());
    }

    @Test
    public void checkoutBookTest_shouldGoBackToMainMenu_WhenCheckoutSuccessful() {
        BookManager.bookList.get(0).setAvailability(true);
        bList.checkoutBook(101);

        assertEquals(AppState.MAIN_MENU, BibliotecaApp.currentState);
    }

    @Test
    public void checkoutBookTest_shouldReturnSuccessMsg_WhenBookIsAvailable() {
        BookManager.bookList.get(0).setAvailability(true);
        assertEquals("Thank you! Enjoy the book", bList.checkoutBook(101));
    }

    @Test
    public void checkoutBookTest_shouldReturnErrorMsg_WhenBookIsNotAvailable() {
        BookManager.bookList.get(0).setAvailability(false);
        assertEquals("Sorry, that book is not available", bList.checkoutBook(101));
    }

    @Test
    public void checkoutBookTest_shouldReturnErrorMsg_WhenIdNotExistent() {
        assertEquals("ID nonexistent", bList.checkoutBook(0));
    }
}