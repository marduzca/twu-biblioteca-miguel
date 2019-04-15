package com.twu.biblioteca.media.videos;

public class Video {

    private int id;
    private String title;
    private int year;
    private String director;
    private int movieRating;
    private boolean available;

    public Video(int id, String title, int year, String director, int movieRating) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.director = director;
        this.movieRating = movieRating;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getMovieRating() {
        return movieRating;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailability(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "[" + getId() + " | " + getTitle() + " | " + getDirector() + " | " + getYear() + "]";
    }
}
