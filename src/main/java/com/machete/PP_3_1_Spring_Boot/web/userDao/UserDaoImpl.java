package com.machete.PP_3_1_Spring_Boot.web.userDao;

import com.machete.PP_3_1_Spring_Boot.web.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional(readOnly = false)
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void deleteUser(User user) {
        User us = entityManager.find(User.class, user.getId());
        entityManager.persist(us);
        entityManager.remove(us);
        entityManager.flush();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
        entityManager.flush();

    }

    @Override
    public void changeUser(User user) {
        User us = entityManager.find(User.class, user.getId());
        entityManager.persist(us);
        us.setId(user.getId());
        us.setName(user.getName());
        us.setLastName(user.getLastName());
        entityManager.flush();


    }
}
