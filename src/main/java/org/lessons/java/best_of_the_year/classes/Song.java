package org.lessons.java.best_of_the_year.classes;

import java.io.Serializable;

public class Song implements Serializable {
    private String title;
    private int id;

    public Song() {
    }

    public Song(String title, int id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public int getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }
}
