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


    public List<MovieDTO> findAllWeekDayMoviesByGenre(String genres, String weekDay) {
        WeekDay requestedWeekDay = WeekDay.valueOf(weekDay.toUpperCase());
        List<String> genreList = Arrays.asList(genres.split("\\s*,\\s*"));

        // If no genres are selected, return all movies for the specified day
        if (genreList.isEmpty()) {
            return MovieSchedule.getMovies().stream()
                    .filter(movie -> movie.getWeekDay() == requestedWeekDay)
                    .map(this::convertToMovieDTO)
                    .collect(Collectors.toList());
        } else {
            // If genres are selected, filter movies by genre and day
            return MovieSchedule.getMovies().stream()
                    .filter(movie -> genreList.stream()
                            .anyMatch(genre -> genre.equalsIgnoreCase(movie.getGenre().getValue()))
                            && movie.getWeekDay() == requestedWeekDay)
                    .map(this::convertToMovieDTO)
                    .collect(Collectors.toList());
        }
    }

    public List<MovieDTO> findAllWeekDayMoviesByAgeRestrictions(String ageRestriction, String weekDay) {
        WeekDay requestedWeekDay = WeekDay.valueOf(weekDay.toUpperCase());
        List<String> ageRestrictionList = Arrays.asList(ageRestriction.split("\\s*,\\s*"));
        if (ageRestrictionList.isEmpty()){
            return MovieSchedule.getMovies().stream()
                    .filter(movie -> movie.getWeekDay() == requestedWeekDay)
                    .map(this::convertToMovieDTO)
                    .collect(Collectors.toList());
        } else {
            return MovieSchedule.getMovies().stream()
                    .filter(movie -> ageRestrictionList.stream()
                            .anyMatch(age -> age.equalsIgnoreCase(movie.getAgeRestriction().getDescription())) &&
                            movie.getWeekDay() == requestedWeekDay)
                    .map(this::convertToMovieDTO)
                    .collect(Collectors.toList());
        }
    }

    public List<MovieDTO> findAllWeekDayMoviesByLanguages(String language, String weekDay) {
        WeekDay requestedWeekDay = WeekDay.valueOf(weekDay.toUpperCase());
        List<String> languageList = Arrays.asList(language.split("\\s*,\\s*"));
        if (languageList.isEmpty()){
            return MovieSchedule.getMovies().stream()
                    .filter(movie -> movie.getWeekDay() == requestedWeekDay)
                    .map(this::convertToMovieDTO)
                    .collect(Collectors.toList());
        } else {
            return MovieSchedule.getMovies().stream()
                    .filter(movie -> languageList.stream()
                            .anyMatch(languages -> languages.equalsIgnoreCase(movie.getLanguage().getLanguage())) &&
                            movie.getWeekDay() == requestedWeekDay)
                    .map(this::convertToMovieDTO)
                    .collect(Collectors.toList());
        }
    }

    public List<MovieDTO> findAllWeekDayMoviesByStartTime(String weekDay, List<Integer> startTimes) {
        WeekDay requestedWeekDay = WeekDay.valueOf(weekDay.toUpperCase());

        return MovieSchedule.getMovies().stream()
                .filter(movie -> startTimes.contains(movie.getStartTime().getHour())
                        && movie.getWeekDay() == requestedWeekDay)
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
        movieDTO.setImageUrl(movie.getImageUrl());
        return movieDTO;
    }
}
