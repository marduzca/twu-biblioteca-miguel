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
    public void showListOfBookTitlesTest() {
        assertEquals("1. Sherlock Holmes\n2. Ready Player One\n3. Strange Case of Dr Jekyll and Mr Hyde", bList.showListOfBooks());
    }

    @Test
    public void showListOfBooksWithExtraInfoTest() {
        assertEquals("1. Sherlock Holmes | Arthur Conan Doyle | 1887\n2. Ready Player One | Ernest Cline | 2011\n3. Strange Case of Dr Jekyll and Mr Hyde | Robert Louis Stevenson | 1886", bList.showListOfBooksWithExtraInfo());
    }

    @Test
    public void checkoutBookTest() {
        assertEquals("Thank you! Enjoy the book", bList.checkoutBook(101));
        assertEquals("Sorry, that book is not available", bList.checkoutBook(101));
    }
}