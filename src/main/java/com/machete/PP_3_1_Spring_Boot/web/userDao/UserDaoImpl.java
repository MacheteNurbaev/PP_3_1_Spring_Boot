package com.machete.PP_3_1_Spring_Boot.web.userDao;

import com.machete.PP_3_1_Spring_Boot.web.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void deleteUser(Long id) {
        User us = entityManager.find(User.class, id);
        if(us == null) {
            throw new EntityNotFoundException();
        }
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
        if(us == null) {
            throw new EntityNotFoundException();
        }
        us.setId(user.getId());
        us.setName(user.getName());
        us.setLastName(user.getLastName());
        entityManager.flush();


    }
}
