package com.webmagic.mapper;


import com.webmagic.model.WebsiteLog;

import java.util.List;

public interface WebsiteLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(WebsiteLog record);

    WebsiteLog selectByPrimaryKey(String id);

    List<WebsiteLog> selectAll();

    int updateByPrimaryKey(WebsiteLog record);
}