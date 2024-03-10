package com.cgi.praktika.movie.business.user.controller;

import com.cgi.praktika.movie.business.user.model.User;
import com.cgi.praktika.movie.business.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    @Operation(summary = "Get User by email and password (login)")
    public User loginUser(@RequestBody User userLogin) {
        return userService.loginUser(userLogin);
    }
}
