package com.qmained.boot.dao;



import com.qmained.boot.models.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    void removeById(long id);

    void updateById(long id, User user);

    User getUser(long id);

    List<User> getListUsers();

}
