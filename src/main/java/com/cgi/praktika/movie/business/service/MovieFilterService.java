package com.cgi.praktika.movie.business.service;

import com.cgi.praktika.movie.business.dto.MovieDTO;
import com.cgi.praktika.movie.business.model.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieFilterService {
    public List<String> findAllMovieGenres() {
        return Arrays.stream(Genre.values())
                .map(Genre::getValue)
                .collect(Collectors.toList());
    }

    public List<String> findAllMovieAgeRestrictions() {
        return Arrays.stream(AgeRestriction.values())
                .map(AgeRestriction::getDescription)
                .collect(Collectors.toList());
    }

    public List<String> findAllMovieLanguages() {
        return Arrays.stream(Language.values())
                .map(Language::getLanguage)
                .collect(Collectors.toList());
    }

    public List<Integer> findAllMovieStartTimes() {
        return Arrays.stream(StartTime.values())
                .map(StartTime::getHour)
                .collect(Collectors.toList());
    }

    public List<WeekDay> findAllWeekDays() {
        return Arrays.asList(WeekDay.values());
    }


    public List<MovieDTO> findAllWeekDayMoviesByGenre(String genre, String weekDay) {
        WeekDay requestedWeekDay = WeekDay.valueOf(weekDay.toUpperCase());
        Genre requestedGenre = Genre.valueOf(genre.toUpperCase());
        return MovieSchedule.getMovies().stream()
                .filter(movie -> movie.getGenre().equals(requestedGenre) && movie.getWeekDay() == requestedWeekDay)
                .map(this::convertToMovieDTO)
                .collect(Collectors.toList());
    }

    public List<MovieDTO> findAllWeekDayMoviesByAgeRestrictions(String ageRestriction, String weekDay) {
        WeekDay requestedWeekDay = WeekDay.valueOf(weekDay.toUpperCase());
        AgeRestriction requestedAgeRestriction = Arrays.stream(AgeRestriction.values())
                .filter(age -> age.getDescription().equalsIgnoreCase(ageRestriction))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid age restriction"));

        return MovieSchedule.getMovies().stream()
                .filter(movie -> movie.getAgeRestriction().equals(requestedAgeRestriction)
                        && movie.getWeekDay() == requestedWeekDay)
                .map(this::convertToMovieDTO)
                .collect(Collectors.toList());
    }

    public List<MovieDTO> findAllWeekDayMoviesByLanguages(String language, String weekDay) {
        WeekDay requestedWeekDay = WeekDay.valueOf(weekDay.toUpperCase());
        Language requestedLanguage = Language.valueOf(language.toUpperCase());
        return MovieSchedule.getMovies().stream()
                .filter(movie -> movie.getLanguage().equals(requestedLanguage)
                        && movie.getWeekDay() == requestedWeekDay)
                .map(this::convertToMovieDTO)
                .collect(Collectors.toList());
    }

    public List<MovieDTO> findAllWeekDayMoviesByStartTime(String weekDay, int startTime) {
        WeekDay requestedWeekDay = WeekDay.valueOf(weekDay.toUpperCase());
        StartTime requestedStartTime = Arrays.stream(StartTime.values())
                .filter(startTime1 -> startTime1.getHour() == startTime)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid start time"));

        return MovieSchedule.getMovies().stream()
                .filter(movie -> movie.getWeekDay() == requestedWeekDay && movie.getStartTime() == requestedStartTime)
                .map(this::convertToMovieDTO)
                .collect(Collectors.toList());
    }

    private MovieDTO convertToMovieDTO(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setName(movie.getName());
        movieDTO.setTime(movie.getStartTime().getLocalTime().toString());
        movieDTO.setGenre(movie.getGenre().getValue());
        movieDTO.setAgeRestriction(movie.getAgeRestriction().getDescription());
        movieDTO.setLanguage(movie.getLanguage().getLanguage());
        movieDTO.setWeekDay(movie.getWeekDay().name());
        return movieDTO;
    }
}
