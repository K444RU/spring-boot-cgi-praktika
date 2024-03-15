package com.cgi.praktika.movie.business.user.service;

import com.cgi.praktika.movie.business.movie.data.MovieHardcodedData;
import com.cgi.praktika.movie.business.movie.model.Genre;
import com.cgi.praktika.movie.business.user.data.UserHardcodedData;
import com.cgi.praktika.movie.business.user.model.Movie;
import com.cgi.praktika.movie.business.user.model.UserMovieHistory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RecommendationAlgorithm {

    public static List<Genre> recommendGenres(int userId) {
        List<UserMovieHistory> userMovieHistory = UserHardcodedData.getUserMovieHistory().stream()
                .filter(history -> history.getUserId() == userId)
                .toList();

        List<Movie> movies = MovieHardcodedData.getMovies();

        List<Movie> watchedMovies = userMovieHistory.stream()
                .map(UserMovieHistory::getMovieId)
                .flatMap(movieId -> movies.stream().filter(movie -> movie.getId() == movieId))
                .toList();

        Map<Genre, Long> genreCounts = watchedMovies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting()));

        return genreCounts.entrySet().stream()
                .sorted(Map.Entry.<Genre, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
