package com.webmagic.dao.base.impl;

import com.webmagic.dao.base.BaseDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public Boolean insert(T var) {

        return null;
    }

    @Override
    public Integer delete(T var) {
        return null;
    }

    @Override
    public Integer update(T var) {
        return null;
    }

    @Override
    public List<T> select(T var) {
        return null;
    }

    @Override
    public T get(Integer id) {
        return null;
    }
}
