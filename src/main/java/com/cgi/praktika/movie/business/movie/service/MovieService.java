package com.cgi.praktika.movie.business.movie.service;

import com.cgi.praktika.movie.business.movie.dto.MovieDTO;
import com.cgi.praktika.movie.business.movie.model.Movie;
import com.cgi.praktika.movie.business.movie.model.MovieSchedule;
import com.cgi.praktika.movie.business.movie.model.WeekDay;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    public List<MovieDTO> findAllMovies() {
        return MovieSchedule.getMovies().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<MovieDTO> findAllMoviesByWeekDay(WeekDay weekDay) {
        return MovieSchedule.getMovies().stream()
                .filter(movie -> movie.getWeekDay() == weekDay)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private MovieDTO convertToDTO(Movie movie) {
        MovieDTO dto = new MovieDTO();
        dto.setId(movie.getId());
        dto.setName(movie.getName());
        dto.setTime(movie.getStartTime().getLocalTime().toString());
        dto.setGenre(movie.getGenre().getValue());
        dto.setAgeRestriction(movie.getAgeRestriction().getDescription());
        dto.setLanguage(movie.getLanguage().getLanguage());
        dto.setWeekDay(movie.getWeekDay().toString());
        dto.setImageUrl(movie.getImageUrl());
        return dto;
    }
}
