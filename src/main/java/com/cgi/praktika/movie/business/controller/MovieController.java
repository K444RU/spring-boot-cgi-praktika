package com.cgi.praktika.movie.business.controller;

import com.cgi.praktika.movie.business.model.Movie;
import com.cgi.praktika.movie.business.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/all")
    @Operation(summary = "Get All available movies")
    public List<Movie> getAllMovies(){
        return movieService.findAllMovies();
    }

    @GetMapping("/monday")
    @Operation(summary = "Get All movies on Monday")
    public List<Movie> getAllMondayMovies(){
        return movieService.findAllMondayMovies();
    }

    @GetMapping("/tuesday")
    @Operation(summary = "Get All movies on Tuesday")
    public List<Movie> getAllTuesdayMovies(){
        return movieService.findAllTuesdayMovies();
    }

    @GetMapping("/wednesday")
    @Operation(summary = "Get All movies on Wednesday")
    public List<Movie> getAllWednesdayMovies(){
        return movieService.findAllWednesdayMovies();
    }

    @GetMapping("/thursday")
    @Operation(summary = "Get All movies on Wednesday")
    public List<Movie> getAllThursdayMovies(){
        return movieService.findAllThursdayMovies();
    }

    @GetMapping("/friday")
    @Operation(summary = "Get All movies on Wednesday")
    public List<Movie> getAllFridayMovies(){
        return movieService.findAllFridayMovies();
    }

    @GetMapping("/saturday")
    @Operation(summary = "Get All movies on Wednesday")
    public List<Movie> getAllSaturdayMovies(){
        return movieService.findAllSaturdayMovies();
    }

    @GetMapping("/sunday")
    @Operation(summary = "Get All movies on Wednesday")
    public List<Movie> getAllSundayMovies(){
        return movieService.findAllSundayMovies();
    }


}
