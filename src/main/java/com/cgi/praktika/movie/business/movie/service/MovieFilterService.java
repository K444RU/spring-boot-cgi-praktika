package com.cgi.praktika.movie.business.movie.service;

import com.cgi.praktika.movie.business.movie.connector.MovieDatabaseConnector;
import com.cgi.praktika.movie.business.movie.data.MovieHardcodedData;
import com.cgi.praktika.movie.business.movie.dto.MovieDTO;
import com.cgi.praktika.movie.business.movie.model.*;
import com.cgi.praktika.movie.business.user.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieFilterService {

    private static final Logger logger = LoggerFactory.getLogger(MovieFilterService.class);

    private final MovieDatabaseConnector movieDatabaseConnector = new MovieDatabaseConnector();

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

        return MovieHardcodedData.getMovieSchedule().stream()
                .filter(schedule -> schedule.getWeekDay() == requestedWeekDay)
                .flatMap(schedule -> MovieHardcodedData.getMovies().stream()
                        .filter(movie -> genreList.stream()
                                .anyMatch(genre -> genre.equalsIgnoreCase(movie.getGenre().getValue())))
                        .filter(movie -> schedule.getMovieId() == movie.getId())
                        .map(movie -> {
                            double rating = getMovieRating(movie.getTmdbId());
                            return convertToMovieDTO(movie, schedule, rating);
                        }))
                .collect(Collectors.toList());
    }

    public List<MovieDTO> findAllWeekDayMoviesByAgeRestrictions(String ageRestrictions, String weekDay) {
        WeekDay requestedWeekDay = WeekDay.valueOf(weekDay.toUpperCase());
        List<String> ageRestrictionList = Arrays.asList(ageRestrictions.split("\\s*,\\s*"));

        return MovieHardcodedData.getMovieSchedule().stream()
                .filter(schedule -> schedule.getWeekDay() == requestedWeekDay)
                .flatMap(schedule -> MovieHardcodedData.getMovies().stream()
                        .filter(movie -> ageRestrictionList.stream()
                                .anyMatch(ageRestriction -> ageRestriction.equalsIgnoreCase(movie.getAgeRestriction().getDescription())))
                        .filter(movie -> schedule.getMovieId() == movie.getId())
                        .map(movie -> {
                            double rating = getMovieRating(movie.getTmdbId());
                            return convertToMovieDTO(movie, schedule, rating);
                        }))
                .collect(Collectors.toList());
    }

    public List<MovieDTO> findAllWeekDayMoviesByLanguages(String languages, String weekDay) {
        WeekDay requestedWeekDay = WeekDay.valueOf(weekDay.toUpperCase());
        List<String> languageList = Arrays.asList(languages.split("\\s*,\\s*"));

        return MovieHardcodedData.getMovieSchedule().stream()
                .filter(schedule -> schedule.getWeekDay() == requestedWeekDay)
                .flatMap(schedule -> MovieHardcodedData.getMovies().stream()
                        .filter(movie -> languageList.stream()
                                .anyMatch(language -> language.equalsIgnoreCase(movie.getLanguage().getLanguage())))
                        .filter(movie -> schedule.getMovieId() == movie.getId())
                        .map(movie -> {
                            double rating = getMovieRating(movie.getTmdbId());
                            return convertToMovieDTO(movie, schedule, rating);
                        }))
                .collect(Collectors.toList());
    }

    public List<MovieDTO> findAllWeekDayMoviesByStartTime(List<Integer> startTimes, String weekDay) {
        WeekDay requestedWeekDay = WeekDay.valueOf(weekDay.toUpperCase());

        return MovieHardcodedData.getMovieSchedule().stream()
                .filter(schedule -> schedule.getWeekDay() == requestedWeekDay)
                .flatMap(schedule -> MovieHardcodedData.getMovies().stream()
                        .filter(movie -> startTimes.contains(schedule.getStartTime().getHour()) && schedule.getMovieId() == movie.getId())
                        .map(movie -> {
                            double rating = getMovieRating(movie.getTmdbId());
                            return convertToMovieDTO(movie, schedule, rating);
                        }))
                .collect(Collectors.toList());
    }

    public List<MovieDTO> findAllWeekDayMoviesByRecommendedGenres(List<Genre> recommendedGenres, String weekDay) {
        WeekDay requestedWeekDay = WeekDay.valueOf(weekDay.toUpperCase());

        List<MovieSchedule> movieSchedule = MovieHardcodedData.getMovieSchedule().stream()
                .filter(schedule -> schedule.getWeekDay() == requestedWeekDay)
                .toList();
        List<Movie> movies = MovieHardcodedData.getMovies();

        List<MovieDTO> unfilteredMovies = new ArrayList<>();
        for (MovieSchedule schedule : movieSchedule) {
            for (Movie movie : movies) {
                if (schedule.getMovieId() == movie.getId()) {
                    double rating = getMovieRating(movie.getTmdbId());
                    unfilteredMovies.add(convertToMovieDTO(movie, schedule, rating));
                    break;
                }
            }
        }

        List<MovieDTO> recommendedMovies = new ArrayList<>();
        List<MovieDTO> restMovies = new ArrayList<>();
        for (Genre recommendedGenre : recommendedGenres) {
            List<MovieDTO> temporaryMovies = new ArrayList<>();
            for (MovieDTO movieDTO : unfilteredMovies) {
                if (!recommendedMovies.contains(movieDTO) && !restMovies.contains(movieDTO)) {
                    if (movieDTO.getGenre().equals(recommendedGenre.getValue())) {
                        temporaryMovies.add(movieDTO);
                    } else {
                        if (recommendedGenres.stream().noneMatch(genre -> genre.getValue().equals(movieDTO.getGenre()))) {
                            restMovies.add(movieDTO);
                        }
                    }
                }
            }

            temporaryMovies = temporaryMovies.stream()
                    .sorted(Comparator.comparing(MovieDTO::getRating).reversed())
                    .toList();
            recommendedMovies.addAll(temporaryMovies);
        }

        restMovies = restMovies.stream()
                .sorted(Comparator.comparing(MovieDTO::getRating).reversed())
                .toList();

        List<MovieDTO> filteredMovies = new ArrayList<>(recommendedMovies);
        filteredMovies.addAll(restMovies);
        return filteredMovies;
    }

    private MovieDTO convertToMovieDTO(Movie movie, MovieSchedule movieSchedule, double rating) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setTmdbId(movie.getTmdbId());
        movieDTO.setName(movie.getName());
        movieDTO.setTime(movieSchedule.getStartTime().getLocalTime().toString());
        movieDTO.setGenre(movie.getGenre().getValue());
        movieDTO.setAgeRestriction(movie.getAgeRestriction().getDescription());
        movieDTO.setLanguage(movie.getLanguage().getLanguage());
        movieDTO.setWeekDay(movieSchedule.getWeekDay().name());
        movieDTO.setImageUrl(movieSchedule.getImageUrl());
        movieDTO.setRating(rating);
        return movieDTO;
    }

    private double getMovieRating(int tmdbId) {
        double rating = 0;
        try {
            rating = movieDatabaseConnector.getMovieRating(tmdbId);
        } catch (IOException e) {
            logger.error("An error occurred while getting movie rating (tmdbId = {}) \n", tmdbId, e);
        }
        return rating;
    }
}
