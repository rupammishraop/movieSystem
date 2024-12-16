package com.movieSystem.movieSystem.Interfaces;

import com.movieSystem.movieSystem.Entity.Movie;

public interface MovieRepository {
    void save(Movie movie);
    Movie getByName(String name);
    void updateMovie(Movie movie);
    void deleteMovie(String name);
}
