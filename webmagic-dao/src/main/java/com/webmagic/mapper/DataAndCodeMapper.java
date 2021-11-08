package com.webmagic.mapper;

import com.webmagic.model.DataAndCode;

import java.util.List;

public interface DataAndCodeMapper {
    int deleteByPrimaryKey(String id);

    int insert(DataAndCode record);

    DataAndCode selectByPrimaryKey(String id);

    List<DataAndCode> selectAll();

    int updateByPrimaryKey(DataAndCode record);
}