package com.twu.biblioteca;

import com.twu.biblioteca.books.BookList;

public class BibliotecaApp {


    private BookList bList;

    public BibliotecaApp(BookList bList) {
        this.bList = bList;
    }

    public static void main(String[] args) {
        System.out.println(showWelcomeMessage());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BookList bList = new BookList();
        new BibliotecaApp(bList);
        System.out.println(bList.showListOfBooks());

        System.out.println(bList.showListOfBooksWithExtraInfo());

    }


    public static String showWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }
}
