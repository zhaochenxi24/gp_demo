package com.zcx.service;

import com.zcx.entity.User;

import java.util.List;

public interface UserService {
    void register(User user);

    User login(String usernanem, String password);

    List<User> findAll();

    void delete(String userID);

    User find(String userID);

    void update(User user);
}
