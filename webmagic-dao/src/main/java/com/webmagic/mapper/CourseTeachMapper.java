package com.webmagic.mapper;

import com.webmagic.model.CourseTeach;

import java.util.List;

public interface CourseTeachMapper {
    int deleteByPrimaryKey(String id);

    int insert(CourseTeach record);

    CourseTeach selectByPrimaryKey(String id);

    List<CourseTeach> selectAll();

    int updateByPrimaryKey(CourseTeach record);
}