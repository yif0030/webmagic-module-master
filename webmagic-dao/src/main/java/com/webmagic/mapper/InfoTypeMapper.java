package com.webmagic.mapper;

import com.webmagic.model.InfoType;
import java.util.List;

public interface InfoTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(InfoType record);

    InfoType selectByPrimaryKey(String id);

    List<InfoType> selectAll();

    int updateByPrimaryKey(InfoType record);
}