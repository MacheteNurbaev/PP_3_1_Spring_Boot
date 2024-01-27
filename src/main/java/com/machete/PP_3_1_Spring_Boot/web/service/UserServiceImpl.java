package com.machete.PP_3_1_Spring_Boot.web.service;

import com.machete.PP_3_1_Spring_Boot.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.machete.PP_3_1_Spring_Boot.web.userDao.Dao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final Dao userDao;

    @Autowired
    public UserServiceImpl(Dao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);

    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);

    }

    @Override
    public void changeUser(User user) {
        userDao.changeUser(user);

    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }
}
