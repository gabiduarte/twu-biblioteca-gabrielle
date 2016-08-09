package com.twu.biblioteca.model;


public class Movie extends Media {
    private String director;
    private int rating;

    public Movie(String name, int year, String director, int rating) {
        super.setName(name);
        super.setYear(year);
        this.director = director;
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
