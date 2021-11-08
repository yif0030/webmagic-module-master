package com.webmagic.mapper;

import com.webmagic.model.Thesis;
import com.webmagic.model.ThesisAttachment;

import java.util.List;

public interface ThesisMapper {
    int deleteByPrimaryKey(String id);

    int insert(Thesis record);

    Thesis selectByPrimaryKey(String id);

    List<Thesis> selectAll();
    
    int updateByPrimaryKey(Thesis record);
}