package com.twu.biblioteca.books;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReturnTest {

    private Return bookReturn;
    private BookManager bookManager;

    @Before
    public void initialize()  {
        bookReturn = new Return();
        bookManager = new BookManager();
    }

    @Test
    public void returnBookTest() {
        assertEquals("That is not a valid book to return", bookReturn.returnBook(101));

        BookManager.bookList.get(0).setAvailability(false);
        assertEquals("Thank you for returning the book", bookReturn.returnBook(101));
    }
}