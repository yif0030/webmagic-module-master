package com.webmagic.mapper;

import com.webmagic.model.User;
import java.util.List;

public interface UserMapper {
    int insert(User record);

    List<User> selectAll();
}