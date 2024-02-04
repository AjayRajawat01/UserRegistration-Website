package com.example.website.services;

import com.example.website.domain.User;

public interface UserService {
    public User getUser();
    public int signUp(String name, String gender, String location, String college);

}
