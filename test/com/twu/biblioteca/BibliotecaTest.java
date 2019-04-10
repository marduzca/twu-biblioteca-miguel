package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    @Test
    public void showWelcomeMessageTest() {
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", BibliotecaApp.showWelcomeMessage());
    }

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
