package com.zcx.service;

import com.zcx.dao.UserDao;
import com.zcx.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.beans.Transient;
import java.util.List;
import java.util.UUID;

@Service
/*控制事务*/
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    /*遍历*/
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void register(User user) {
        user.setUserID(UUID.randomUUID().toString());
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User find(String userID) {
        return userDao.find(userID);
    }

    @Override
    public void delete(String userID) {
        userDao.delete(userID);
    }

    @Override
    public User login(String usernanem, String password) {
        return userDao.login(usernanem,password);
    }
}
