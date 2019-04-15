package com.twu.biblioteca.media.books;

import java.util.ArrayList;
import java.util.List;

public class BookManager {

    private List<Book> bookList = new ArrayList<>();
    private List<Book> availableBooks;

    public BookManager(){
        bookList.add(new Book(101, "Sherlock Holmes", "Arthur Conan Doyle", 1887));
        bookList.add(new Book(102,"Ready Player One", "Ernest Cline", 2011));
        bookList.add(new Book(103,"Strange Case of Dr Jekyll and Mr Hyde", "Robert Louis Stevenson", 1886));

        availableBooks = new ArrayList<>(bookList);
    }

    public String showListOfBooks() {
        updateAvailableBooksList();

        StringBuffer bookListAsText = new StringBuffer();

        for(int i = 0; i < availableBooks.size(); i++) {
            bookListAsText.append((i+1) + ". " + availableBooks.get(i).getTitle() + " | " + availableBooks.get(i).getAuthor() + " | " + availableBooks.get(i).getYear() + "\n");
        }

        return bookListAsText.toString().trim();
    }

    public void updateAvailableBooksList() {
        for(Book b : bookList) {
            if(!b.isAvailable() && availableBooks.contains(b)) {
                availableBooks.remove(b);
            }
            else if(b.isAvailable() && !availableBooks.contains(b)) {
                availableBooks.add(b);
            }
        }
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }
}