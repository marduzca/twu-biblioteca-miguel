package com.twu.biblioteca.books;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckoutTest {

    private Checkout bList;

    @Before
    public void initialize () {
        bList = new Checkout();
    }

    @Test
    public void checkoutBookTest() {
        assertEquals("Thank you! Enjoy the book", bList.checkoutBook(101));
        assertEquals("Sorry, that book is not available", bList.checkoutBook(101));
    }
}