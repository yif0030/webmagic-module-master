package com.webmagic.service;

import com.webmagic.model.User;

import java.util.List;

public interface UserService {

    Integer insert(User user);

    Integer delete(User user);

    Integer update(User user);

    List<User> select(User user);

    User get(Integer id);
}
