package com.qmained.boot.service;




import com.qmained.boot.models.User;

import java.util.List;

public interface UserService {
    void add(User user);

    void removeById(long id);

    void updateById(long id, User user);
    User getUser(long id);

    List<User> getListUsers();


}
