package com.webmagic.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.webmagic.model.Notice;

import java.util.List;

public interface NoticeMapper extends BaseMapper<Notice> {
    int deleteByPrimaryKey(String id);

    Integer insert(Notice record);

    Notice selectByPrimaryKey(String id);

    List<Notice> selectAll();

    int updateByPrimaryKey(Notice record);
}