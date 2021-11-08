package com.webmagic.mapper;

import com.webmagic.model.Institute;
import java.util.List;

public interface InstituteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Institute record);

    Institute selectByPrimaryKey(Integer id);

    List<Institute> selectAll();

    int updateByPrimaryKey(Institute record);
}