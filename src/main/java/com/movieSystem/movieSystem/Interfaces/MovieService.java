package com.movieSystem.movieSystem.Interfaces;

import com.movieSystem.movieSystem.Entity.Movie;
import com.movieSystem.movieSystem.Entity.MovieRequest;

public interface MovieService {
    void create(MovieRequest movieRequest);
    Movie get(String name);
    void update(String name, MovieRequest movieRequest);
    void delete(String name);
}
