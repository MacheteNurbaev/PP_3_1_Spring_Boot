package com.machete.PP_3_1_Spring_Boot.web.userDao;

import com.machete.PP_3_1_Spring_Boot.web.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void deleteUser(User user);

    void addUser(User user);

    void changeUser(User user);
}
