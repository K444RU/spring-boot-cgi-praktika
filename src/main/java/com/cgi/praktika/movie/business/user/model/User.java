package com.cgi.praktika.movie.business.user.model;

import lombok.Data;

@Data
public class User {

    private int id;
    private String email;
    private String password;

    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}
