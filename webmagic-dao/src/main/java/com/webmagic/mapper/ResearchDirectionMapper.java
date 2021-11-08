package com.webmagic.mapper;

import com.webmagic.model.ResearchDirection;

import java.util.List;

public interface ResearchDirectionMapper {
    int deleteByPrimaryKey(String id);

    int insert(ResearchDirection record);

    ResearchDirection selectByPrimaryKey(String id);

    List<ResearchDirection> selectAll();

    int updateByPrimaryKey(ResearchDirection record);
}