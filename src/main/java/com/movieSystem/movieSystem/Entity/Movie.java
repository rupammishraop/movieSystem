package com.movieSystem.movieSystem.Entity;

import lombok.*;


public class Movie {
    private String name;
    private String genre;
    private String language;

    public Movie(String name, String genre, String language) {
        this.name = name;
        this.genre = genre;
        this.language = language;
    }

    public Movie() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
