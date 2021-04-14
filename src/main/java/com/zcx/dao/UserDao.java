package com.zcx.dao;

import com.zcx.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface UserDao {
    void save(User user);

    User login(@RequestParam("username") String username, @RequestParam("password") String password);

    List<User> findAll();

    void delete(String userID);

    User find(String userID);

    void update(User user);
}
