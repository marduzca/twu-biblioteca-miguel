package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookList {

    private List<Book> bookList = new ArrayList<>();

    public BookList(){
        bookList.add(new Book("Sherlock Holmes", "Arthur Conan Doyle", 1887));
        bookList.add(new Book("Ready Player One", "Ernest Cline", 2011));
        bookList.add(new Book("Strange Case of Dr Jekyll and Mr Hyde", "Robert Louis Stevenson", 1886));
    }

    public String showListOfBooks() {
        StringBuffer bookListAsText = new StringBuffer();

        for(Book b : bookList) {
            bookListAsText.append(b.getTitle() + "\n");
        }

        return bookListAsText.toString().trim();
    }

    public String showListOfBooksWithExtraInfo() {
        StringBuffer bookListWithExtraInfoAsText = new StringBuffer();

        for(Book b : bookList) {
            bookListWithExtraInfoAsText.append(b.getTitle() + " | " + b.getAuthor() + " | " + b.getYear() + "\n");
        }

        return bookListWithExtraInfoAsText.toString().trim();
    }
}
