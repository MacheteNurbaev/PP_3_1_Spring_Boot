package com.machete.PP_3_1_Spring_Boot.web.service;

import com.machete.PP_3_1_Spring_Boot.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.machete.PP_3_1_Spring_Boot.web.userDao.UserDao;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);

    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);

    }

    @Override
    public void changeUser(User user) {
        userDao.changeUser(user);

    }
}
