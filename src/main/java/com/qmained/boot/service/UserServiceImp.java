package com.qmained.boot.service;


import com.qmained.boot.dao.UserDao;
import com.qmained.boot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void removeById(long id) {
        userDao.removeById(id);
    }

    @Override
    public void updateById(long id, User user) {
        userDao.updateById(id, user);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUser(long id) {
        return userDao.getUser(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getListUsers() {
        return userDao.getListUsers();
    }



}
