package com.twu.biblioteca.accounts;

import com.twu.biblioteca.books.Book;
import com.twu.biblioteca.videos.Video;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private User accountOwner;
    private String libraryID;
    private char[] password;
    private List<Book> rentedBooksList;
    private List<Video> rentedVideosList;

    public Account(User accountOwner, String libraryID, char[] password) {
        this.accountOwner = accountOwner;
        this.libraryID = libraryID;
        this.password = password;
        this.rentedBooksList = new ArrayList<Book>();
        this.rentedVideosList = new ArrayList<Video>();
    }

    public Account() {
        this.rentedBooksList = new ArrayList<Book>();
        this.rentedVideosList = new ArrayList<Video>();
    }

    public User getAccountOwner() {
        return accountOwner;
    }

    public String getLibraryID() {
        return libraryID;
    }

    public char[] getPassword() {
        return password;
    }

    public List<Book> getRentedBooksList() {
        return rentedBooksList;
    }

    public List<Video> getRentedVideosList() {
        return rentedVideosList;
    }
}
