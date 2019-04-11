package com.twu.biblioteca.books;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookManagerTest {

    private BookManager bookManager;

    @Before
    public void initialize() {
        bookManager = new BookManager();
    }

    @Test
    public void showListOfBooksWithExtraInfoTest() {
        assertEquals("1. Sherlock Holmes | Arthur Conan Doyle | 1887\n2. Ready Player One | Ernest Cline | 2011\n3. Strange Case of Dr Jekyll and Mr Hyde | Robert Louis Stevenson | 1886", bookManager.showListOfBooks());
    }

}