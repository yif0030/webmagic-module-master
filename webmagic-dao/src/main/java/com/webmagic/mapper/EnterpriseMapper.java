package com.webmagic.mapper;

import com.webmagic.model.Enterprise;

import java.util.List;

public interface EnterpriseMapper {
    int deleteByPrimaryKey(String id);

    int insert(Enterprise record);

    Enterprise selectByPrimaryKey(String id);

    List<Enterprise> selectAll();

    int updateByPrimaryKey(Enterprise record);
}