package com.cgi.praktika.movie.business.user.data;

import com.cgi.praktika.movie.business.user.model.User;
import com.cgi.praktika.movie.business.user.model.UserMovieHistory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserHardcodedData {

    public static List<User> getUsers() {
        return new ArrayList<>(Arrays.asList(
                new User(1, "oleg@cgi.com", "123"),
                new User(2, "cgi@cgi.com", "321")
        ));
    }

    public static List<UserMovieHistory> getUserMovieHistory() {
        return new ArrayList<>(Arrays.asList(
                new UserMovieHistory(1, 1, 1), // Drama
                new UserMovieHistory(2, 1, 2), // Drama
                new UserMovieHistory(3, 1, 3), // Drama
                new UserMovieHistory(4, 1, 11), // Comedy
                new UserMovieHistory(5, 1, 8), // Comedy
                new UserMovieHistory(6, 1, 14), // Action

                new UserMovieHistory(7, 2, 8), // Comedy
                new UserMovieHistory(8, 2, 11), // Comedy
                new UserMovieHistory(9, 2, 17), // Comedy
                new UserMovieHistory(10, 2, 6), // Drama
                new UserMovieHistory(11, 2, 1), // Drama
                new UserMovieHistory(12, 2, 10) // Cartoon
        ));
    }
}
