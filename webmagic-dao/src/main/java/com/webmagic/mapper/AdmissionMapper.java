package com.webmagic.mapper;

import com.webmagic.model.Admission;

import java.util.List;

public interface AdmissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Admission record);

    Admission selectByPrimaryKey(String id);

    List<Admission> selectAll();

    int updateByPrimaryKey(Admission record);
}