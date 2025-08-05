package org.lessons.java.best_of_the_year.classes;

public class Movie {
    private String title;
    private int id;

    public Movie() {
    }

    public Movie(String title, int id) {
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
