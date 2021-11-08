package com.webmagic.dao.base;

import java.util.List;

public interface BaseDao<T> {

    Boolean insert(T var);

    Integer delete(T var);

    Integer update(T var);

    List<T> select(T var);

    T get(Integer id);
}
