package com.webmagic.mapper;

import com.webmagic.model.WebsiteConfig;
import java.util.List;

public interface WebsiteConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WebsiteConfig record);

    WebsiteConfig selectByPrimaryKey(Integer id);

    List<WebsiteConfig> selectAll();

    int updateByPrimaryKey(WebsiteConfig record);
}