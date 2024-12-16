package com.movieSystem.movieSystem.controller;

import com.movieSystem.movieSystem.Entity.Movie;
import com.movieSystem.movieSystem.Entity.MovieRequest;
import com.movieSystem.movieSystem.Interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Resources {

    @Autowired
    MovieService movieService;

    @PostMapping("/v1/movie")
    void create(@RequestBody MovieRequest movieRequest){
        movieService.create(movieRequest);
    }

    @GetMapping("/v1/movie")
    Movie get(@RequestParam("name") String name){
        return movieService.get(name);
    }

    @PutMapping("/v1/movie/{name}")
    void update(@PathVariable("name") String name, @RequestBody MovieRequest movieRequest){
        movieService.update(name, movieRequest);
    }

    @DeleteMapping("v1/movie/{name}")
    void delete(@PathVariable("name") String name){
         movieService.delete(name);
    }
}
