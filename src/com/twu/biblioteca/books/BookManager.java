package com.twu.biblioteca.books;

import java.util.ArrayList;
import java.util.List;

public class BookManager {

    public static List<Book> bookList = new ArrayList<>();

    public BookManager(){
        bookList.add(new Book(101, "Sherlock Holmes", "Arthur Conan Doyle", 1887));
        bookList.add(new Book(102,"Ready Player One", "Ernest Cline", 2011));
        bookList.add(new Book(103,"Strange Case of Dr Jekyll and Mr Hyde", "Robert Louis Stevenson", 1886));
    }

    public String showListOfBooks() {
        StringBuffer bookListAsText = new StringBuffer();

        for(int i = 0; i < bookList.size(); i++) {
            if(bookList.get(i).isAvailable())
                bookListAsText.append((101 + i) + ". " + bookList.get(i).getTitle() + "\n");
        }

        return bookListAsText.toString().trim();
    }

    public String showListOfBooksWithExtraInfo() {
        StringBuffer bookListWithExtraInfoAsText = new StringBuffer();

        for(int i = 0; i < bookList.size(); i++) {
            if(bookList.get(i).isAvailable())
                bookListWithExtraInfoAsText.append((101 + i) + ". " + bookList.get(i).getTitle() + " | " + bookList.get(i).getAuthor() + " | " + bookList.get(i).getYear() + "\n");
        }

        return bookListWithExtraInfoAsText.toString().trim();
    }
}
