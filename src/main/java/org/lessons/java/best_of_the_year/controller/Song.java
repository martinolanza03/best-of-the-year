package org.lessons.java.best_of_the_year.controller;

public class Song {
    private String title;
    private int id;

    public Song() {
    }

    public Song(String title, int id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }
}
