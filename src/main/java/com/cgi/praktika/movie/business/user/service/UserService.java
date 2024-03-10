package com.cgi.praktika.movie.business.user.service;

import com.cgi.praktika.movie.business.movie.model.Genre;
import com.cgi.praktika.movie.business.user.model.HardcodedData;
import com.cgi.praktika.movie.business.user.model.HistoryMovies;
import com.cgi.praktika.movie.business.user.model.RecommendationAlgorithm;
import com.cgi.praktika.movie.business.user.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public User loginUser(User userLogin) {
        User hardcodedUser = HardcodedData.getHardcodedUser();
        if (hardcodedUser.getEmail().equals(userLogin.getEmail()) &&
                hardcodedUser.getPassword().equals(userLogin.getPassword())) {
            return hardcodedUser;
        } else {
            return null;
        }
    }

    public List<Genre> getRecommendedGenres(int userId, List<HistoryMovies> userHistory) {
        return RecommendationAlgorithm.recommendGenres(userId,userHistory);
    }
}
