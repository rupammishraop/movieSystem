package com.movieSystem.movieSystem.controller;

import com.movieSystem.movieSystem.Entity.Movie;
import com.movieSystem.movieSystem.Entity.MovieRequest;
import com.movieSystem.movieSystem.Interfaces.MovieRepository;
import com.movieSystem.movieSystem.Interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public void create(MovieRequest movieRequest) {
        Movie movie = new Movie();
        movie.setName(movieRequest.getName());
        movie.setGenre(movieRequest.getGenre());
        movie.setLanguage(movieRequest.getLanguage());

        Movie tempMovie = get(movie.getName());
        if(tempMovie == null){
            movieRepository.save(movie);
        }

    }

    @Override
    public Movie get(String name) {
      return movieRepository.getByName(name);
    }

    @Override
    public void update(String name, MovieRequest movieRequest) {
        Movie movie = get(name);
        if(movieRequest.getGenre() != null){
            movie.setGenre(movieRequest.getGenre());
        }
        if(movieRequest.getLanguage() != null){
            movie.setLanguage(movieRequest.getLanguage());
        }
        movieRepository.updateMovie(movie);
    }

    @Override
    public void delete(String name) {
      movieRepository.deleteMovie(name);
    }

}
