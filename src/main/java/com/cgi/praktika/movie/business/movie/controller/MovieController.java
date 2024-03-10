package com.cgi.praktika.movie.business.movie.controller;

import com.cgi.praktika.movie.business.movie.dto.MovieDTO;
import com.cgi.praktika.movie.business.movie.model.WeekDay;
import com.cgi.praktika.movie.business.movie.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<MovieDTO> getAllMovies(){
        return movieService.findAllMovies();
    }

    @GetMapping("/by-weekday")
    @Operation(summary = "Filter movies by weekday")
    public List<MovieDTO> getMoviesByWeekDay(@RequestParam String weekDay) {
        WeekDay requestedWeekDay = WeekDay.valueOf(weekDay.toUpperCase());
        return movieService.findAllMoviesByWeekDay(requestedWeekDay);
    }
}
