package com.cgi.praktika.movie.business.user.service;

import com.cgi.praktika.movie.business.movie.model.Genre;
import com.cgi.praktika.movie.business.user.data.UserHardcodedData;
import com.cgi.praktika.movie.business.user.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    public User loginUser(User userLogin) {
        List<User> hardcodedUsers = UserHardcodedData.getUsers();
        Optional<User> user = hardcodedUsers.stream()
                .filter(hardcodedUser -> hardcodedUser.getEmail().equals(userLogin.getEmail()) && hardcodedUser.getPassword().equals(userLogin.getPassword()))
                .findFirst();
        return user.orElse(null);
    }

    public List<Genre> getRecommendedGenres(int userId) {
        return RecommendationAlgorithm.recommendGenres(userId);
    }
}
