package com.twu.biblioteca.books;

import com.twu.biblioteca.main.BibliotecaApp;
import com.twu.biblioteca.util.AppState;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookCheckoutTest {

    private static BookCheckout bList;
    private static BookManager bookManager;

    @BeforeClass
    public static void initialize () {
        bList = new BookCheckout();
        bookManager = new BookManager();
    }

    @Test
    public void checkoutBookTest_shouldReturnErrorMsg_WhenBookIsNotAvailable() {
        BookManager.getBookList().get(0).setAvailability(false);
        BookManager.updateAvailableBooksList();

        assertEquals("Sorry, that book is not available", bList.checkoutBook(101));
    }

    @Test
    public void checkoutBookTest_shouldBeUnavailable_WhenCheckoutSuccessful() {
        BookManager.getBookList().get(0).setAvailability(true);
        BookManager.updateAvailableBooksList();
        bList.checkoutBook(101);

        assertEquals(false, BookManager.getBookList().get(0).isAvailable());
    }

    @Test
    public void checkoutBookTest_shouldGoBackToMainMenu_WhenCheckoutSuccessful() {
        BookManager.getBookList().get(0).setAvailability(true);
        bList.checkoutBook(101);

        assertEquals(AppState.MAIN_MENU, BibliotecaApp.currentState);
    }

    @Test
    public void checkoutBookTest_shouldReturnSuccessMsg_WhenBookIsAvailable() {
        BookManager.getBookList().get(0).setAvailability(true);
        BookManager.updateAvailableBooksList();
        assertEquals("Thank you! Enjoy the book", bList.checkoutBook(101));
    }
}