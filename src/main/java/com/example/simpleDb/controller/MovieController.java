package com.example.simpleDb.controller;

import com.example.simpleDb.model.Movie;
import com.example.simpleDb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("/app")
    String appName(){
        return "MovieNames";
    }

    @GetMapping("/listMovie")
    List<String> listMovie(){
        return movieService.getMovieList();
    }

    @GetMapping("/insertMovie")
    Movie insertMovie(@Param("moviename") String movieName){
        return movieService.insertMovie(movieName);
    }

}
