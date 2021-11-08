package com.webmagic.mapper;

import com.webmagic.model.SysConfig;
import java.util.List;

public interface SysConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysConfig record);

    SysConfig selectByPrimaryKey(Integer id);

    List<SysConfig> selectAll();

    int updateByPrimaryKey(SysConfig record);
}