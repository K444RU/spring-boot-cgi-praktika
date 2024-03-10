package com.cgi.praktika.movie.business.user.model;

import com.cgi.praktika.movie.business.movie.model.Genre;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RecommendationAlgorithm {

    public static List<Genre> recommendGenres(int userId, List<HistoryMovies> userHistory) {
        Map<Genre, Long> genreCounts = userHistory.stream()
                .collect(Collectors.groupingBy(HistoryMovies::getGenre, Collectors.counting()));

        return genreCounts.entrySet().stream()
                .sorted(Map.Entry.<Genre, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
