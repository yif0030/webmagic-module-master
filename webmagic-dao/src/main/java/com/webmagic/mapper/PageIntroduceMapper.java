package com.webmagic.mapper;

import com.webmagic.model.PageIntroduce;

import java.util.List;

public interface PageIntroduceMapper {
    int deleteByPrimaryKey(String id);

    int insert(PageIntroduce record);

    PageIntroduce selectByPrimaryKey(String id);

    List<PageIntroduce> selectAll();

    int updateByPrimaryKey(PageIntroduce record);
}