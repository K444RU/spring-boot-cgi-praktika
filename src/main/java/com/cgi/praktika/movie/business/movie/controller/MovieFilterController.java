package com.cgi.praktika.movie.business.movie.controller;

import com.cgi.praktika.movie.business.movie.dto.MovieDTO;
import com.cgi.praktika.movie.business.movie.model.WeekDay;
import com.cgi.praktika.movie.business.movie.service.MovieFilterService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("filter")
public class MovieFilterController {

    private final MovieFilterService movieFilterService;


    public MovieFilterController(MovieFilterService movieFilterService) {
        this.movieFilterService = movieFilterService;
    }

    @GetMapping("/all/genres")
    @Operation(summary = "Get all movie genres")
    public List<String> getAllMovieGenres(){
        return movieFilterService.findAllMovieGenres();
    }

    @GetMapping("/all/age-restrictions")
    @Operation(summary = "Get all movie age restrictions")
    public List<String> getAllMovieAgeRestrictions(){
        return movieFilterService.findAllMovieAgeRestrictions();
    }

    @GetMapping("/all/languages")
    @Operation(summary = "Get all movie genres")
    public List<String> getAllMovieLanguages(){
        return movieFilterService.findAllMovieLanguages();
    }

    @GetMapping("/all/start-times")
    @Operation(summary = "Get all movie start times")
    public List<Integer> getAllMovieStartTimes(){
        return movieFilterService.findAllMovieStartTimes();
    }

    @GetMapping("/all/week-days")
    @Operation(summary = "Get all week days")
    public List<WeekDay> getAllWeekDays(){
        return movieFilterService.findAllWeekDays();
    }


    @GetMapping("/by-genre")
    @Operation(summary = "Filter each day movies by genre")
    public List<MovieDTO> getWeekDayMoviesByGenre(@RequestParam String genre, @RequestParam String weekDay){
        return movieFilterService.findAllWeekDayMoviesByGenre(genre, weekDay);
    }

    @GetMapping("/by-age-restriction")
    @Operation(summary = "Filter each day movies by age restrictions")
    public List<MovieDTO> getWeekDayMoviesByAgeRestrictions(
            @RequestParam String ageRestriction, @RequestParam String weekDay) {
        return movieFilterService.findAllWeekDayMoviesByAgeRestrictions(ageRestriction, weekDay);
    }

    @GetMapping("/by-language")
    @Operation(summary = "Filter each day movies by language")
    public List<MovieDTO> getWeekDayMoviesByLanguages(
            @RequestParam String language, @RequestParam String weekDay){
        return movieFilterService.findAllWeekDayMoviesByLanguages(language, weekDay);
    }

    @GetMapping("/by-start-time")
    @Operation(summary = "Filter each day movies by start time")
    public List<MovieDTO> getWeekDayMoviesByStartTime(
            @RequestParam String weekDay, @RequestParam List<Integer> startTimes) {
        return movieFilterService.findAllWeekDayMoviesByStartTime(weekDay, startTimes);
    }

}
