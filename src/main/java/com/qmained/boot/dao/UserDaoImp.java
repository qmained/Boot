package com.qmained.boot.dao;

import com.qmained.boot.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    private void flushAndClear() {
        entityManager.flush();
        entityManager.clear();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
        flushAndClear();
    }

    @Override
    public void removeById(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        flushAndClear();
    }

    @Override
    public void updateById(long id, User user) {
        entityManager.merge(user);
        flushAndClear();
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getListUsers() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }



}
