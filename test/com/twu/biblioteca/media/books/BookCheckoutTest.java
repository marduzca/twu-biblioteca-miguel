package com.twu.biblioteca.media.books;

import com.twu.biblioteca.accounts.LoginManager;
import com.twu.biblioteca.main.BibliotecaApp;
import com.twu.biblioteca.util.AppState;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookCheckoutTest {

    private static BibliotecaApp bibApp;
    private static BookCheckout bList;
    private static BookManager bookManager;
    private static LoginManager loginManager;

    @BeforeClass
    public static void initialize () {
        bibApp = new BibliotecaApp();
        loginManager = new LoginManager(bibApp.console);
        bibApp.currentAccount = loginManager.getAccountsList().get(0);
        bookManager = new BookManager();
        bList = new BookCheckout(bibApp, bookManager, bibApp.console);
    }

    @Test
    public void checkoutBookTest_shouldStayInCheckoutBookMenu_WhenBookIsNotAvailable() {
        bookManager.getBookList().get(0).setAvailability(false);
        bookManager.updateAvailableBooksList();

        assertEquals(AppState.CHEKOUT_BOOK_MENU, bList.checkoutBook(101));
    }

    @Test
    public void checkoutBookTest_shouldBeUnavailable_WhenCheckoutSuccessful() {
        bookManager.getBookList().get(0).setAvailability(true);
        bookManager.updateAvailableBooksList();
        bList.checkoutBook(101);

        assertEquals(false, bookManager.getBookList().get(0).isAvailable());
    }

    @Test
    public void checkoutBookTest_shouldGoBackToMainMenu_WhenBookIsAvailable() {
        bookManager.getBookList().get(0).setAvailability(true);
        bookManager.updateAvailableBooksList();

        assertEquals(AppState.MAIN_MENU, bList.checkoutBook(101));
    }
}