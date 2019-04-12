package com.twu.biblioteca.videos;

public class Video {

    private int id;
    private String name;
    private int year;
    private String director;
    private int movieRating;
    private boolean available;

    public Video(int id, String name, int year, String director, int movieRating) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.movieRating = movieRating;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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
}
