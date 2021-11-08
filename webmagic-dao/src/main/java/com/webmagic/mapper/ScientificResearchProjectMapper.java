package com.webmagic.mapper;

import com.webmagic.model.ScientificResearchProject;

import java.util.List;

public interface ScientificResearchProjectMapper {
    int deleteByPrimaryKey(String id);

    int insert(ScientificResearchProject record);

    ScientificResearchProject selectByPrimaryKey(String id);

    List<ScientificResearchProject> selectAll();

    int updateByPrimaryKey(ScientificResearchProject record);
}