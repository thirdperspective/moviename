package com.example.simpleDb.service;

import com.example.simpleDb.model.Movie;
import com.example.simpleDb.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<String> getMovieList(){
        return movieRepository.findAll()
                .stream().map(movie -> {return movie.getName();})
                .collect(Collectors.toList());
    }

    public Movie insertMovie(String movieName) {
        Movie movieEntity = new Movie();
        movieEntity.setName(movieName);
        return movieRepository.save(movieEntity);
    }
}
