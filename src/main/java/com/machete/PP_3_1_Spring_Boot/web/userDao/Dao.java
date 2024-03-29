package com.machete.PP_3_1_Spring_Boot.web.userDao;

import com.machete.PP_3_1_Spring_Boot.web.model.User;

import java.util.List;

public interface Dao {

    List<User> getAllUsers();

    void deleteUser(Long id);

    void addUser(User user);

    void changeUser(User user);

    User getUser(Long id);
}
