package com.cgi.praktika.movie.business.movie.service;

import com.cgi.praktika.movie.business.movie.connector.MovieDatabaseConnector;
import com.cgi.praktika.movie.business.movie.data.MovieHardcodedData;
import com.cgi.praktika.movie.business.movie.dto.MovieDTO;
import com.cgi.praktika.movie.business.movie.model.MovieSchedule;
import com.cgi.praktika.movie.business.movie.model.WeekDay;
import com.cgi.praktika.movie.business.user.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private static final Logger logger = LoggerFactory.getLogger(MovieService.class);

    private final MovieDatabaseConnector movieDatabaseConnector = new MovieDatabaseConnector();

    public List<MovieDTO> findAllMovies() {
        return MovieHardcodedData.getMovieSchedule().stream()
                .flatMap(schedule -> MovieHardcodedData.getMovies().stream()
                        .map(movie -> {
                            double rating = getMovieRating(movie.getTmdbId());
                            return convertToMovieDTO(movie, schedule, rating);
                        }))
                .collect(Collectors.toList());
    }

    public MovieDTO findMovieInformationByMovieId(int movieId) {
        System.out.println(movieId);
        Optional<MovieDTO> foundMovie = MovieHardcodedData.getMovieSchedule().stream()
                .flatMap(schedule -> MovieHardcodedData.getMovies().stream()
                        .filter(movie -> movie.getId() == movieId)
                        .map(movie -> {
                            double rating = getMovieRating(movie.getTmdbId());
                            return convertToMovieDTO(movie, schedule, rating);
                        }))
                .findFirst();

        return foundMovie.orElse(null);
    }

    public List<MovieDTO> findAllMoviesByWeekDay(WeekDay weekDay) {
        return MovieHardcodedData.getMovieSchedule().stream()
                .filter(schedule -> schedule.getWeekDay() == weekDay)
                .flatMap(schedule -> MovieHardcodedData.getMovies().stream()
                        .filter(movie -> movie.getId() == schedule.getMovieId())
                        .map(movie -> {
                            double rating = getMovieRating(movie.getTmdbId());
                            return convertToMovieDTO(movie, schedule, rating);
                        }))
                .collect(Collectors.toList());
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
