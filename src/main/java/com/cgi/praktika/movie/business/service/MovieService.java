package com.cgi.praktika.movie.business.service;

import com.cgi.praktika.movie.business.model.Movie;
import com.cgi.praktika.movie.business.model.MovieSchedule;
import com.cgi.praktika.movie.business.model.WeekDay;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    public static List<Movie> findAllMovies() {
        return MovieSchedule.getMovies();
    }

    public List<Movie> findAllMondayMovies() {
        return MovieSchedule.getMovies().stream()
                .filter(movie -> movie.getWeekDay() == WeekDay.MONDAY)
                .collect(Collectors.toList());
    }

    public List<Movie> findAllTuesdayMovies() {
        return MovieSchedule.getMovies().stream()
                .filter(movie -> movie.getWeekDay() == WeekDay.TUESDAY)
                .collect(Collectors.toList());
    }

    public List<Movie> findAllWednesdayMovies() {
        return MovieSchedule.getMovies().stream()
                .filter(movie -> movie.getWeekDay() == WeekDay.WEDNESDAY)
                .collect(Collectors.toList());
    }

    public List<Movie> findAllThursdayMovies() {
        return MovieSchedule.getMovies().stream()
                .filter(movie -> movie.getWeekDay() == WeekDay.THURSDAY)
                .collect(Collectors.toList());
    }

    public List<Movie> findAllFridayMovies() {
        return MovieSchedule.getMovies().stream()
                .filter(movie -> movie.getWeekDay() == WeekDay.FRIDAY)
                .collect(Collectors.toList());
    }

    public List<Movie> findAllSaturdayMovies() {
        return MovieSchedule.getMovies().stream()
                .filter(movie -> movie.getWeekDay() == WeekDay.SATURDAY)
                .collect(Collectors.toList());
    }

    public List<Movie> findAllSundayMovies() {
        return MovieSchedule.getMovies().stream()
                .filter(movie -> movie.getWeekDay() == WeekDay.SUNDAY)
                .collect(Collectors.toList());
    }
}
