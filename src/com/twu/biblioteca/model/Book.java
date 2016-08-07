package com.twu.biblioteca.model;

public class Book {
    private int ID;
    private String name;
    private String author;
    private int year;
    private boolean isCheckedOut;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getBookID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) { isCheckedOut = checkedOut; }

    public void setBookID(int bookID) { this.ID = bookID; }
}
