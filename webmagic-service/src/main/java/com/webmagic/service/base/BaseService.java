package com.webmagic.service.base;

import java.util.List;

public interface BaseService<T> {

    Integer insert(T var);

    Integer delete(T var);

    Integer update(T var);

    List<T> select(T var);

    T get(Integer id);

}
