package com.twu.biblioteca.accounts;

import com.twu.biblioteca.media.books.Book;
import com.twu.biblioteca.media.videos.Video;

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

    public void assignRentedBook(Book rentedBook) {
        rentedBooksList.add(rentedBook);
    }

    public void unassignReturnedBook(Book returnedBook) {
        rentedBooksList.remove(returnedBook);
    }

    public void assignRentedVideo(Video rentedVideo) {
        rentedVideosList.add(rentedVideo);
    }

    @Override
    public String toString(){
        StringBuffer info = new StringBuffer();
        info.append("Library ID: " + getLibraryID());
        info.append("\nName: " + accountOwner.getName());
        info.append("\nEmail: " + accountOwner.getEmail());
        info.append("\nMobile: " + accountOwner.getPhoneNumber());
        info.append("\nRented books: " + (rentedBooksList.size() > 0 ? rentedBooksList.toString() : "No books rented at the moment"));
        info.append("\nRented videos: " + (rentedVideosList.size() > 0 ? rentedVideosList.toString() : "No videos rented at the moment"));

        return info.toString();
    }
}
