package com.twu.biblioteca.books;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookListTest {

    @Test
    public void showListOfBookTitlesTest() {
        BookList bList = new BookList();
        assertEquals("Sherlock Holmes\nReady Player One\nStrange Case of Dr Jekyll and Mr Hyde", bList.showListOfBooks());
    }

    @Test
    public void showListOfBooksWithExtraInfoTest() {
        BookList bList = new BookList();
        assertEquals("Sherlock Holmes | Arthur Conan Doyle | 1887\nReady Player One | Ernest Cline | 2011\nStrange Case of Dr Jekyll and Mr Hyde | Robert Louis Stevenson | 1886", bList.showListOfBooksWithExtraInfo());
    }
}