package com.webmagic.mapper;

import com.webmagic.model.SysDicType;
import java.util.List;

public interface SysDicTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysDicType record);

    SysDicType selectByPrimaryKey(String id);

    List<SysDicType> selectAll();

    int updateByPrimaryKey(SysDicType record);
}